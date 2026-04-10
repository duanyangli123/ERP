package org.example.modules.system.service.impl;

import org.example.modules.system.entity.SysRole;
import org.example.modules.system.mapper.SysRoleMapper;
import org.example.modules.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色Service实现类
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}