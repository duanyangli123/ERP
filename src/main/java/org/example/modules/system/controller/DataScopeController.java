package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.auth.context.DataScopeContext;
import org.example.modules.system.auth.enums.DataScopeType;
import org.example.modules.system.auth.model.LoginUser;
import org.example.modules.system.entity.SysRole;
import org.example.modules.system.service.DataScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数据权限Controller
 */
@RestController
@RequestMapping("/api/system/dataScope")
public class DataScopeController {

    @Autowired
    private DataScopeService dataScopeService;

    /**
     * 获取当前用户数据权限
     */
    @GetMapping("/current")
    public ApiResponse<Map<String, Object>> getCurrentDataScope() {
        LoginUser loginUser = getCurrentUser();
        if (loginUser == null) {
            return ApiResponse.fail("用户未登录");
        }

        DataScopeType dataScopeType = dataScopeService.getDataScopeType(loginUser.getUserId());
        Set<Long> deptIds = dataScopeService.getDeptIds(loginUser.getUserId(), dataScopeType);

        // 设置到上下文
        DataScopeContext.setDataScope(dataScopeType, deptIds, "");

        Map<String, Object> result = new HashMap<>();
        result.put("dataScopeType", dataScopeType.getCode());
        result.put("dataScopeTypeName", dataScopeType.getDescription());
        result.put("deptIds", deptIds);

        return ApiResponse.success(result);
    }

    /**
     * 手动设置数据权限范围
     */
    @PostMapping("/set")
    public ApiResponse<Void> setDataScope(@RequestBody Map<String, Object> params) {
        Integer dataScopeType = (Integer) params.get("dataScopeType");
        String deptIdsStr = (String) params.get("deptIds");

        Set<Long> deptIds = null;
        if (deptIdsStr != null && !deptIdsStr.isEmpty()) {
            deptIds = new java.util.HashSet<>();
            for (String id : deptIdsStr.split(",")) {
                if (id.trim().matches("\\d+")) {
                    deptIds.add(Long.parseLong(id.trim()));
                }
            }
        }

        DataScopeContext.setDataScope(
            DataScopeType.fromCode(dataScopeType),
            deptIds,
            ""
        );

        return ApiResponse.success(null);
    }

    /**
     * 清除数据权限上下文
     */
    @PostMapping("/clear")
    public ApiResponse<Void> clearDataScope() {
        DataScopeContext.clear();
        return ApiResponse.success(null);
    }

    /**
     * 检查用户是否有数据权限
     */
    @GetMapping("/check")
    public ApiResponse<Boolean> checkDataScope(
            @RequestParam Long creatorId,
            @RequestParam Long deptId) {
        LoginUser loginUser = getCurrentUser();
        if (loginUser == null) {
            return ApiResponse.fail("用户未登录");
        }

        boolean hasPermission = dataScopeService.canAccess(loginUser, creatorId, deptId);
        return ApiResponse.success(hasPermission);
    }

    private LoginUser getCurrentUser() {
        // 从安全上下文获取当前用户
        return org.example.modules.system.auth.util.SecurityUtils.getCurrentUser();
    }
}