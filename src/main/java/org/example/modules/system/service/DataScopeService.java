package org.example.modules.system.service;

import org.example.modules.system.auth.enums.DataScopeType;
import org.example.modules.system.auth.model.LoginUser;

import java.util.Set;

/**
 * 数据权限服务
 * 处理用户数据权限范围计算
 */
public interface DataScopeService {

    /**
     * 获取用户的数据权限范围
     * @param userId 用户ID
     * @return 数据权限类型
     */
    DataScopeType getDataScopeType(Long userId);

    /**
     * 获取用户可访问的部门ID集合
     * @param userId 用户ID
     * @param dataScopeType 数据权限类型
     * @return 部门ID集合
     */
    Set<Long> getDeptIds(Long userId, DataScopeType dataScopeType);

    /**
     * 获取用户可访问的部门及子部门ID集合
     * @param deptId 部门ID
     * @return 部门及子部门ID集合
     */
    Set<Long> getDeptAndChildIds(Long deptId);

    /**
     * 检查用户是否有数据权限
     * @param loginUser 登录用户
     * @param targetDeptId 目标部门ID
     * @return 是否有权限
     */
    boolean hasDataScope(LoginUser loginUser, Long targetDeptId);

    /**
     * 检查用户是否有访问某条数据的权限
     * @param loginUser 登录用户
     * @param creatorId 数据创建人ID
     * @param deptId 数据部门ID
     * @return 是否有权限
     */
    boolean canAccess(LoginUser loginUser, Long creatorId, Long deptId);
}