package org.example.modules.system.service;

import java.util.List;
import org.example.modules.system.entity.SysMenu;
import org.example.modules.system.model.SysMenuTreeVO;

public interface SysMenuService {

    List<SysMenu> listAll();

    List<SysMenuTreeVO> listTree();

    List<SysMenuTreeVO> listCurrentUserMenus();

    boolean saveMenu(SysMenu menu);

    List<Long> getRoleMenuIds(Long roleId);

    boolean assignRoleMenus(Long roleId, List<Long> menuIds);
}
