package org.example.modules.system.auth.model;

import java.util.Collections;
import java.util.List;
import lombok.Data;

@Data
public class LoginUser {

    private Long userId;
    private Long tenantId;
    private String username;
    private String realName;
    private Integer status;
    private Long issuedAt;
    private Long expireAt;
    private List<String> roleCodes = Collections.emptyList();
    private List<String> permissionCodes = Collections.emptyList();
}
