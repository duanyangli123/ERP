package org.example.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysOperLog;
import org.example.modules.system.service.SysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 操作日志Controller
 */
@RestController
@RequestMapping("/api/system/operLog")
public class SysOperLogController {

    @Autowired
    private SysOperLogService operLogService;

    /**
     * 分页查询操作日志
     */
    @GetMapping("/page")
    public ApiResponse<IPage<SysOperLog>> getPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String module,
            @RequestParam(required = false) String operType,
            @RequestParam(required = false) String operUserName,
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime) {

        Page<SysOperLog> page = new Page<>(pageNum, pageSize);
        IPage<SysOperLog> result = operLogService.getPage(page, module, operType, operUserName, startTime, endTime);
        return ApiResponse.success(result);
    }

    /**
     * 获取日志详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysOperLog> getById(@PathVariable Long id) {
        SysOperLog log = operLogService.getById(id);
        return ApiResponse.success(log);
    }

    /**
     * 删除日志
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        operLogService.removeById(id);
        return ApiResponse.success(null);
    }

    /**
     * 批量删除日志
     */
    @DeleteMapping("/batch")
    public ApiResponse<Void> deleteBatch(@RequestBody java.util.List<Long> ids) {
        operLogService.removeByIds(ids);
        return ApiResponse.success(null);
    }

    /**
     * 清理历史日志
     */
    @DeleteMapping("/clean")
    public ApiResponse<Integer> cleanLogs(@RequestParam(defaultValue = "90") int days) {
        int count = operLogService.cleanLogs(days);
        return ApiResponse.success(count);
    }
}