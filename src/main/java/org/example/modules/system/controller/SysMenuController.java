package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysMenu;
import org.example.modules.system.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单Controller
 */
@RestController
@RequestMapping("/system/menu")
@RequiredArgsConstructor
public class SysMenuController {

    private final SysMenuService sysMenuService;

    /**
     * 分页查询菜单列表
     */
    @GetMapping("/page")
    public ApiResponse<Page<SysMenu>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String menuName,
            @RequestParam(required = false) Integer menuType,
            @RequestParam(required = false) Boolean status) {
        
        Page<SysMenu> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SysMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(menuName != null, SysMenu::getMenuName, menuName)
                .eq(menuType != null, SysMenu::getMenuType, menuType)
                .eq(status != null, SysMenu::getStatus, status)
                .orderByAsc(SysMenu::getSort);
        
        return ApiResponse.success(sysMenuService.page(page, wrapper));
    }

    /**
     * 获取菜单树形列表
     */
    @GetMapping("/tree")
    public ApiResponse<List<SysMenu>> tree() {
        return ApiResponse.success(sysMenuService.getMenuTree());
    }

    /**
     * 获取所有菜单列表
     */
    @GetMapping("/list")
    public ApiResponse<List<SysMenu>> list() {
        return ApiResponse.success(sysMenuService.getAllMenus());
    }

    /**
     * 获取菜单详情
     */
    @GetMapping("/{id}")
    public ApiResponse<SysMenu> getById(@PathVariable Long id) {
        return ApiResponse.success(sysMenuService.getById(id));
    }

    /**
     * 新增菜单
     */
    @PostMapping
    public ApiResponse<Boolean> add(@RequestBody SysMenu sysMenu) {
        return ApiResponse.success(sysMenuService.save(sysMenu));
    }

    /**
     * 更新菜单
     */
    @PutMapping
    public ApiResponse<Boolean> update(@RequestBody SysMenu sysMenu) {
        return ApiResponse.success(sysMenuService.updateById(sysMenu));
    }

    /**
     * 删除菜单
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> delete(@PathVariable Long id) {
        return ApiResponse.success(sysMenuService.removeById(id));
    }
}