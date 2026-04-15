package org.example.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.system.entity.SysMenu;
import org.example.modules.system.mapper.SysMenuMapper;
import org.example.modules.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> getAllMenus() {
        return list();
    }

    @Override
    public List<SysMenu> getMenuTree() {
        return list();
    }

    @Override
    public List<SysMenu> getMenusByUserId(Long userId) {
        return list();
    }
}