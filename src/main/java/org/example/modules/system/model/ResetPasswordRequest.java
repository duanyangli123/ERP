package org.example.modules.system.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResetPasswordRequest {

    @NotNull(message = "userId is required")
    private Long userId;

    @NotBlank(message = "newPassword is required")
    private String newPassword;
}
