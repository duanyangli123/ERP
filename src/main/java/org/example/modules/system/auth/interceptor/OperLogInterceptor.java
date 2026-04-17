package org.example.modules.system.auth.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.example.modules.system.auth.annotation.OperLog;
import org.example.modules.system.auth.model.LoginUser;
import org.example.modules.system.auth.util.SecurityUtils;
import org.example.modules.system.entity.SysOperLog;
import org.example.modules.system.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 操作日志拦截器
 * 在方法执行后自动记录操作日志
 */
@Component
public class OperLogInterceptor implements HandlerInterceptor {

    @Autowired
    private SysOperLogService operLogService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<>();
    private static final ThreadLocal<SysOperLog> LOG_HOLDER = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            OperLog operLog = handlerMethod.getMethodAnnotation(OperLog.class);
            if (operLog != null) {
                // 记录开始时间
                START_TIME.set(System.currentTimeMillis());

                // 创建日志实体
                SysOperLog log = new SysOperLog();
                log.setModule(operLog.module());
                log.setOperType(operLog.operType());
                log.setMethod(handlerMethod.getBeanType().getName() + "." + handlerMethod.getMethod().getName());
                log.setRequestUrl(request.getRequestURI());
                log.setRequestMethod(request.getMethod());
                log.setOperIp(getClientIp(request));
                log.setOperLocation("");
                log.setCreateTime(LocalDateTime.now());

                // 获取当前用户
                LoginUser user = SecurityUtils.getCurrentUser();
                if (user != null) {
                    log.setOperUserId(user.getUserId());
                    log.setOperUserName(user.getUsername());
                }

                // 记录请求参数
                if (operLog.logParam()) {
                    String requestParam = getRequestParam(request);
                    if (StringUtils.isNotBlank(requestParam)) {
                        log.setRequestParam(truncate(requestParam, 4000));
                    }
                }

                LOG_HOLDER.set(log);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SysOperLog log = LOG_HOLDER.get();
        if (log != null) {
            // 计算耗时
            Long startTime = START_TIME.get();
            if (startTime != null) {
                log.setCostTime(System.currentTimeMillis() - startTime);
            }

            // 设置状态
            log.setStatus(ex == null ? 1 : 0);
            if (ex != null) {
                log.setErrorMsg(truncate(ex.getMessage(), 2000));
            }

            // 记录返回结果
            if (response.getStatus() >= 200 && response.getStatus() < 300) {
                // 成功
            }

            // 异步保存日志
            operLogService.saveLog(log);

            // 清理ThreadLocal
            START_TIME.remove();
            LOG_HOLDER.remove();
        }
    }

    /**
     * 获取客户端IP地址
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多个代理时取第一个IP
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }

    /**
     * 获取请求参数
     */
    private String getRequestParam(HttpServletRequest request) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!parameterMap.isEmpty()) {
                return objectMapper.writeValueAsString(parameterMap);
            }
            // POST请求从输入流读取（需要调用方先读取，这里简化处理）
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 截断字符串
     */
    private String truncate(String str, int maxLength) {
        if (str == null) {
            return "";
        }
        if (str.length() > maxLength) {
            return str.substring(0, maxLength) + "...";
        }
        return str;
    }
}