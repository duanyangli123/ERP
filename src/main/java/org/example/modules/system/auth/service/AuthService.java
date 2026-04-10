package org.example.modules.system.auth.service;

import org.example.modules.system.auth.model.LoginRequest;
import org.example.modules.system.auth.model.LoginResponse;

/**
 * 认证Service接口
 */
public interface AuthService {

    /**
     * 用户登录
     */
    LoginResponse login(LoginRequest request);

    /**
     * 用户登出
     */
    void logout(String token);

    /**
     * 获取当前登录用户信息
     */
    Object getCurrentUser(String token);
}