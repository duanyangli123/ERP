package org.example.modules.system.controller;

import org.example.common.model.ApiResponse;
import org.example.modules.system.auth.model.LoginRequest;
import org.example.modules.system.auth.model.LoginResponse;
import org.example.modules.system.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 认证Controller
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = authService.login(request);
            return ApiResponse.success(response);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 用户登出
     */
    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestHeader(value = "Authorization", required = false) String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            authService.logout(token);
        }
        return ApiResponse.success();
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping("/info")
    public ApiResponse<Object> getUserInfo(@RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ApiResponse.error(401, "未登录");
        }
        token = token.substring(7);
        Object userInfo = authService.getCurrentUser(token);
        if (userInfo == null) {
            return ApiResponse.error(401, "登录已过期");
        }
        return ApiResponse.success(userInfo);
    }
}