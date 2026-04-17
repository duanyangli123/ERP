package org.example.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.system.entity.SysOperLog;
import org.example.modules.system.mapper.SysOperLogMapper;
import org.example.modules.system.service.SysOperLogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 操作日志Service实现类
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {

    @Override
    public IPage<SysOperLog> getPage(Page<SysOperLog> page, String module, String operType,
                                      String operUserName, String startTime, String endTime) {
        LambdaQueryWrapper<SysOperLog> wrapper = new LambdaQueryWrapper<>();

        if (module != null && !module.isEmpty()) {
            wrapper.like(SysOperLog::getModule, module);
        }
        if (operType != null && !operType.isEmpty()) {
            wrapper.eq(SysOperLog::getOperType, operType);
        }
        if (operUserName != null && !operUserName.isEmpty()) {
            wrapper.like(SysOperLog::getOperUserName, operUserName);
        }
        if (startTime != null && !startTime.isEmpty()) {
            wrapper.ge(SysOperLog::getCreateTime, startTime);
        }
        if (endTime != null && !endTime.isEmpty()) {
            wrapper.le(SysOperLog::getCreateTime, endTime);
        }

        wrapper.orderByDesc(SysOperLog::getCreateTime);
        return this.page(page, wrapper);
    }

    @Override
    @Async
    public void saveLog(SysOperLog log) {
        if (log.getCreateTime() == null) {
            log.setCreateTime(LocalDateTime.now());
        }
        this.save(log);
    }

    @Override
    public int cleanLogs(int days) {
        LocalDateTime beforeTime = LocalDateTime.now().minusDays(days);
        return this.baseMapper.delete(
            new LambdaQueryWrapper<SysOperLog>()
                .lt(SysOperLog::getCreateTime, beforeTime)
        );
    }
}