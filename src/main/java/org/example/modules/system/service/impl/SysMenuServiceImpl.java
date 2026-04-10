package org.example.modules.system.service.impl;

import org.example.modules.system.entity.SysMenu;
import org.example.modules.system.mapper.SysMenuMapper;
import org.example.modules.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单Service实现类
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> getAllMenus() {
        return list();
    }

    @Override
    public List<SysMenu> getMenuTree() {
        List<SysMenu> allMenus = list();
        return buildMenuTree(allMenus, 0L);
    }

    @Override
    @Cacheable(value = "menu", key = "#userId")
    public List<SysMenu> getMenusByUserId(Long userId) {
        // TODO: 根据用户角色获取菜单权限
        return list();
    }

    /**
     * 构建菜单树
     */
    private List<SysMenu> buildMenuTree(List<SysMenu> menus, Long parentId) {
        return menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .collect(Collectors.toList());
    }
}