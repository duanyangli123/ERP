package org.example.modules.system.auth.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class UserProfileVO {

    private Long id;
    private Long tenantId;
    private String username;
    private String realName;
    private String mobile;
    private String email;
    private Long deptId;
    private Long postId;
    private Integer status;
    private LocalDateTime lastLoginTime;
    private List<String> roleCodes;
    private List<String> permissionCodes;
}