package org.example.modules.system.service.impl;

import org.example.modules.system.auth.enums.DataScopeType;
import org.example.modules.system.auth.model.LoginUser;
import org.example.modules.system.entity.SysDept;
import org.example.modules.system.entity.SysRole;
import org.example.modules.system.mapper.SysDeptMapper;
import org.example.modules.system.service.DataScopeService;
import org.example.modules.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据权限服务实现
 */
@Service
public class DataScopeServiceImpl implements DataScopeService {

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysDeptMapper deptMapper;

    @Override
    public DataScopeType getDataScopeType(Long userId) {
        // 获取用户角色列表
        List<SysRole> roles = roleService.getRolesByUserId(userId);
        if (roles == null || roles.isEmpty()) {
            return DataScopeType.ALL; // 无角色，默认看全部数据
        }

        // 取角色中最大的数据权限范围
        int maxScope = 1; // 默认全部
        for (SysRole role : roles) {
            Integer dataScope = role.getDataScope();
            if (dataScope != null && dataScope > maxScope) {
                maxScope = dataScope;
            }
        }

        return DataScopeType.fromCode(maxScope);
    }

    @Override
    public Set<Long> getDeptIds(Long userId, DataScopeType dataScopeType) {
        Set<Long> deptIds = new HashSet<>();

        switch (dataScopeType) {
            case ALL:
                // 全部数据，不需要限制部门
                break;
            case SELF:
                // 仅本人，不需要部门ID
                break;
            case DEPT:
                // 本部门
                Long deptId = getUserDeptId(userId);
                if (deptId != null) {
                    deptIds.add(deptId);
                }
                break;
            case DEPT_AND_CHILD:
                // 本部门及以下
                Long deptId2 = getUserDeptId(userId);
                if (deptId2 != null) {
                    deptIds.addAll(getDeptAndChildIds(deptId2));
                }
                break;
            case CUSTOM:
                // 自定义，从角色配置中获取
                List<SysRole> roles = roleService.getRolesByUserId(userId);
                for (SysRole role : roles) {
                    if (role.getDataScopeDeptIdSet() != null) {
                        deptIds.addAll(role.getDataScopeDeptIdSet());
                    }
                }
                break;
            default:
                break;
        }

        return deptIds;
    }

    @Override
    public Set<Long> getDeptAndChildIds(Long deptId) {
        Set<Long> result = new HashSet<>();
        result.add(deptId);

        // 递归获取所有子部门
        List<SysDept> allDepts = deptMapper.selectList(null);
        findChildDepts(deptId, allDepts, result);

        return result;
    }

    private void findChildDepts(Long parentId, List<SysDept> allDepts, Set<Long> result) {
        for (SysDept dept : allDepts) {
            if (parentId.equals(dept.getParentId())) {
                result.add(dept.getId());
                findChildDepts(dept.getId(), allDepts, result);
            }
        }
    }

    @Override
    public boolean hasDataScope(LoginUser loginUser, Long targetDeptId) {
        if (loginUser == null || targetDeptId == null) {
            return false;
        }

        // 超级管理员不受限制
        if (isSuperAdmin(loginUser)) {
            return true;
        }

        DataScopeType dataScopeType = getDataScopeType(loginUser.getUserId());
        if (dataScopeType == DataScopeType.ALL) {
            return true;
        }

        Set<Long> deptIds = getDeptIds(loginUser.getUserId(), dataScopeType);
        if (deptIds.isEmpty()) {
            // 仅本人权限，检查是否为自己的数据
            return loginUser.getUserId().equals(targetDeptId);
        }

        return deptIds.contains(targetDeptId);
    }

    @Override
    public boolean canAccess(LoginUser loginUser, Long creatorId, Long deptId) {
        if (loginUser == null) {
            return false;
        }

        // 超级管理员不受限制
        if (isSuperAdmin(loginUser)) {
            return true;
        }

        // 获取数据权限类型
        DataScopeType dataScopeType = getDataScopeType(loginUser.getUserId());

        switch (dataScopeType) {
            case ALL:
                return true;
            case SELF:
                return loginUser.getUserId().equals(creatorId);
            case DEPT:
                // 本部门
                Long userDeptId = getUserDeptId(loginUser.getUserId());
                return userDeptId != null && userDeptId.equals(deptId);
            case DEPT_AND_CHILD:
                // 本部门及以下
                Set<Long> deptIds = getDeptIds(loginUser.getUserId(), dataScopeType);
                return deptIds.contains(deptId);
            case CUSTOM:
                // 自定义
                Set<Long> customDeptIds = getDeptIds(loginUser.getUserId(), dataScopeType);
                return customDeptIds.contains(deptId);
            default:
                return false;
        }
    }

    /**
     * 获取用户所属部门ID
     */
    private Long getUserDeptId(Long userId) {
        // 从部门表中查询
        SysDept dept = deptMapper.selectOneByUserId(userId);
        return dept != null ? dept.getId() : null;
    }

    /**
     * 判断是否为超级管理员
     */
    private boolean isSuperAdmin(LoginUser loginUser) {
        if (loginUser.getRoleCodes() == null) {
            return false;
        }
        return loginUser.getRoleCodes().stream()
                .anyMatch(role -> "SUPER_ADMIN".equals(role));
    }
}