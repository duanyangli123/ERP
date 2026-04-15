package org.example.modules.system.auth.service.impl;

import org.example.modules.system.auth.model.LoginRequest;
import org.example.modules.system.auth.model.LoginResponse;
import org.example.modules.system.auth.service.AuthService;
import org.example.modules.system.auth.util.JwtUtils;
import org.example.modules.system.entity.SysUser;
import org.example.modules.system.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证Service实现类
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SysUserService sysUserService;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public LoginResponse login(LoginRequest request) {
        System.out.println("Login request: " + request.getUsername() + " / " + request.getPassword());
        // 查询用户
        System.out.println("Querying user: " + request.getUsername());
        SysUser user = sysUserService.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, request.getUsername()));
        
        System.out.println("User found: " + (user != null));
        if (user != null) {
            System.out.println("User status: " + user.getStatus() + ", password hash: " + user.getPassword().substring(0, 20) + "...");
        }

        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 验证密码
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 检查用户状态
        if (user.getStatus() == null || !user.getStatus()) {
            throw new RuntimeException("用户已被禁用");
        }

        // 生成Token
        String token = jwtUtils.generateToken(user.getUsername(), user.getId());

        return new LoginResponse(token, user.getId(), user.getUsername(), user.getNickname());
    }

    @Override
    public void logout(String token) {
        // TODO: 可以将token加入黑名单
    }

    @Override
    public Object getCurrentUser(String token) {
        if (!jwtUtils.validateToken(token)) {
            return null;
        }
        
        Long userId = jwtUtils.getUserIdFromToken(token);
        SysUser user = sysUserService.getById(userId);
        
        if (user == null) {
            return null;
        }
        
        // 返回用户信息（不包含密码）
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", user.getUsername());
        userInfo.put("nickname", user.getNickname());
        userInfo.put("avatar", user.getAvatar());
        userInfo.put("phone", user.getPhone());
        userInfo.put("email", user.getEmail());
        
        return userInfo;
    }
}