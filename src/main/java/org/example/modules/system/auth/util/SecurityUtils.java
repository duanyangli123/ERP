package org.example.modules.system.auth.util;

import org.example.modules.system.auth.context.UserContext;
import org.example.modules.system.auth.model.LoginUser;

/**
 * 安全工具类
 * 用于获取当前登录用户信息
 */
public class SecurityUtils {

    /**
     * 获取当前登录用户
     */
    public static LoginUser getCurrentUser() {
        return UserContext.getUser();
    }

    /**
     * 获取当前用户ID
     */
    public static Long getCurrentUserId() {
        return UserContext.getUserId();
    }

    /**
     * 获取当前用户名
     */
    public static String getCurrentUsername() {
        return UserContext.getUsername();
    }

    /**
     * 判断是否为超级管理员
     */
    public static boolean isSuperAdmin() {
        LoginUser user = getCurrentUser();
        if (user == null || user.getRoleCodes() == null) {
            return false;
        }
        return user.getRoleCodes().stream()
                .anyMatch(role -> "SUPER_ADMIN".equals(role));
    }

    /**
     * 判断是否拥有指定角色
     */
    public static boolean hasRole(String roleCode) {
        LoginUser user = getCurrentUser();
        if (user == null || user.getRoleCodes() == null) {
            return false;
        }
        return user.getRoleCodes().contains(roleCode);
    }

    /**
     * 判断是否拥有指定权限
     */
    public static boolean hasPermission(String permission) {
        LoginUser user = getCurrentUser();
        if (user == null || user.getPermissionCodes() == null) {
            return false;
        }
        return user.getPermissionCodes().contains(permission);
    }
}