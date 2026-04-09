package org.example.modules.system.auth.service;

import org.example.modules.system.auth.model.LoginRequest;
import org.example.modules.system.auth.model.LoginResponse;
import org.example.modules.system.auth.model.UserProfileVO;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    UserProfileVO getCurrentUser();

    void logout(String token);
}
