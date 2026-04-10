package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysDept;
import org.example.modules.system.service.SysDeptService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门Controller
 */
@RestController
@RequestMapping("/system/dept")
@RequiredArgsConstructor
public class SysDeptController {

    private final SysDeptService sysDeptService;

    /**
     * 分页查询部门列表
     */
    @GetMapping("/page")
    public ApiResponse<Page<SysDept>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String deptName,
            @RequestParam(required = false) Boolean status) {
        
        Page<SysDept> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysDept> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(deptName != null, SysDept::getDeptName, deptName)
                .eq(status != null, SysDept::getStatus, status)
                .orderByAsc(SysDept::getSort);
        
        return ApiResponse.success(sysDeptService.page(page, wrapper));
    }

    /**
     * 获取部门树形列表
     */
    @GetMapping("/tree")
    public ApiResponse<List<SysDept>> tree() {
        return ApiResponse.success(sysDeptService.getDeptTree());
    }

    /**
     * 获取所有部门列表
     */
    @GetMapping("/list")
    public ApiResponse<List<SysDept>> list() {
        return ApiResponse.success(sysDeptService.getAllDepts());
    }

    /**
     * 获取部门详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysDept> getById(@PathVariable Long id) {
        return ApiResponse.success(sysDeptService.getById(id));
    }

    /**
     * 新增部门
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody SysDept sysDept) {
        return ApiResponse.success(sysDeptService.save(sysDept));
    }

    /**
     * 更新部门
     */
    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody SysDept sysDept) {
        return ApiResponse.success(sysDeptService.updateById(sysDept));
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(sysDeptService.removeById(id));
    }
}