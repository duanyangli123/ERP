package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysPost;
import org.example.modules.system.service.SysPostService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位Controller
 */
@RestController
@RequestMapping("/system/post")
@RequiredArgsConstructor
public class SysPostController {

    private final SysPostService sysPostService;

    /**
     * 分页查询岗位列表
     */
    @GetMapping("/page")
    public ApiResponse<Page<SysPost>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String postName,
            @RequestParam(required = false) String postCode,
            @RequestParam(required = false) Boolean status) {
        
        Page<SysPost> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysPost> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(postName != null, SysPost::getPostName, postName)
                .like(postCode != null, SysPost::getPostCode, postCode)
                .eq(status != null, SysPost::getStatus, status)
                .orderByAsc(SysPost::getSort);
        
        return ApiResponse.success(sysPostService.page(page, wrapper));
    }

    /**
     * 获取所有岗位列表
     */
    @GetMapping("/list")
    public ApiResponse<?> list() {
        return ApiResponse.success(sysPostService.list());
    }

    /**
     * 获取岗位详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysPost> getById(@PathVariable Long id) {
        return ApiResponse.success(sysPostService.getById(id));
    }

    /**
     * 新增岗位
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody SysPost sysPost) {
        return ApiResponse.success(sysPostService.save(sysPost));
    }

    /**
     * 更新岗位
     */
    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody SysPost sysPost) {
        return ApiResponse.success(sysPostService.updateById(sysPost));
    }

    /**
     * 删除岗位
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(sysPostService.removeById(id));
    }
}