package org.example.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.modules.system.entity.SysRole;
import org.example.modules.system.entity.SysUserRole;
import org.example.modules.system.mapper.SysRoleMapper;
import org.example.modules.system.mapper.SysUserRoleMapper;
import org.example.modules.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色Service实现类
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public List<SysRole> getRolesByUserId(Long userId) {
        // 查询用户角色关联
        List<SysUserRole> userRoles = userRoleMapper.selectList(
            new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId)
        );

        if (userRoles.isEmpty()) {
            return Collections.emptyList();
        }

        // 获取角色ID列表
        List<Long> roleIds = userRoles.stream()
                .map(SysUserRole::getRoleId)
                .collect(Collectors.toList());

        // 查询角色列表
        return this.listByIds(roleIds);
    }
}