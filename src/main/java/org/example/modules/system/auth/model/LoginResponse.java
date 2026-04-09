package org.example.modules.system.auth.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String tokenType;
    private LocalDateTime expireTime;
    private UserProfileVO user;
    private List<String> roleCodes;
    private List<String> permissionCodes;
}
