package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysUser;
import org.example.modules.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 */
@RestController
@RequestMapping("/system/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    /**
     * 分页查询用户列表
     */
    @GetMapping("/page")
    public ApiResponse<IPage<SysUser>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) Boolean status) {
        
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(username != null, SysUser::getUsername, username)
                .like(nickname != null, SysUser::getNickname, nickname)
                .eq(status != null, SysUser::getStatus, status)
                .orderByDesc(SysUser::getCreatedTime);
        
        return ApiResponse.success(sysUserService.page(page, wrapper));
    }

    /**
     * 获取用户详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysUser> getById(@PathVariable Long id) {
        return ApiResponse.success(sysUserService.getById(id));
    }

    /**
     * 新增用户
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody SysUser sysUser) {
        return ApiResponse.success(sysUserService.save(sysUser));
    }

    /**
     * 更新用户
     */
    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody SysUser sysUser) {
        return ApiResponse.success(sysUserService.updateById(sysUser));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(sysUserService.removeById(id));
    }
}
