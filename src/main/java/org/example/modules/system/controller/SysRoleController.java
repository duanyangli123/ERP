package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysRole;
import org.example.modules.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 角色Controller
 */
@RestController
@RequestMapping("/system/role")
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService sysRoleService;

    /**
     * 分页查询角色列表
     */
    @GetMapping("/page")
    public ApiResponse<Page<SysRole>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String roleName,
            @RequestParam(required = false) Boolean status) {
        
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(roleName != null, SysRole::getRoleName, roleName)
                .eq(status != null, SysRole::getStatus, status)
                .orderByDesc(SysRole::getSort);
        
        return ApiResponse.success(sysRoleService.page(page, wrapper));
    }

    /**
     * 获取所有角色列表
     */
    @GetMapping("/list")
    public ApiResponse<?> list() {
        return ApiResponse.success(sysRoleService.list());
    }

    /**
     * 获取角色详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysRole> getById(@PathVariable Long id) {
        return ApiResponse.success(sysRoleService.getById(id));
    }

    /**
     * 新增角色
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody SysRole sysRole) {
        return ApiResponse.success(sysRoleService.save(sysRole));
    }

    /**
     * 更新角色
     */
    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody SysRole sysRole) {
        return ApiResponse.success(sysRoleService.updateById(sysRole));
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(sysRoleService.removeById(id));
    }
}