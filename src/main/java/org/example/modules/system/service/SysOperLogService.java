package org.example.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.system.entity.SysOperLog;

/**
 * 操作日志Service接口
 */
public interface SysOperLogService extends IService<SysOperLog> {

    /**
     * 分页查询操作日志
     * @param page 分页参数
     * @param module 模块名称
     * @param operType 操作类型
     * @param operUserName 操作人
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 分页结果
     */
    IPage<SysOperLog> getPage(Page<SysOperLog> page, String module, String operType,
                              String operUserName, String startTime, String endTime);

    /**
     * 保存操作日志
     * @param log 日志实体
     */
    void saveLog(SysOperLog log);

    /**
     * 清理历史日志
     * @param days 保留天数
     * @return 删除数量
     */
    int cleanLogs(int days);
}