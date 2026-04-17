package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作日志实体
 */
@Data
@TableName("sys_oper_log")
public class SysOperLog {

    /**
     * 日志ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 模块名称
     */
    private String module;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求URL
     */
    private String requestUrl;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回结果
     */
    private String responseResult;

    /**
     * 操作人ID
     */
    private Long operUserId;

    /**
     * 操作人用户名
     */
    private String operUserName;

    /**
     * 操作人IP
     */
    private String operIp;

    /**
     * 操作地点
     */
    private String operLocation;

    /**
     * 耗时（毫秒）
     */
    private Long costTime;

    /**
     * 状态：0-失败，1-成功
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}