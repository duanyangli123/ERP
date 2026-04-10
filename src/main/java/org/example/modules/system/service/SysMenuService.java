package org.example.modules.system.service;

import org.example.modules.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 菜单Service接口
 */
public interface SysMenuService extends IService<SysMenu> {
    
    /**
     * 获取所有菜单列表
     */
    List<SysMenu> getAllMenus();
    
    /**
     * 获取菜单树形列表
     */
    List<SysMenu> getMenuTree();
    
    /**
     * 根据用户ID获取菜单列表
     */
    List<SysMenu> getMenusByUserId(Long userId);
}