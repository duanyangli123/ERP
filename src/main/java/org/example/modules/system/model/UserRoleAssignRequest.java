package org.example.modules.system.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRoleAssignRequest {

    @NotNull(message = "userId is required")
    private Long userId;

    private List<Long> roleIds;
}
