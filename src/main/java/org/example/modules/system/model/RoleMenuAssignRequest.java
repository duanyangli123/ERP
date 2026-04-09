package org.example.modules.system.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleMenuAssignRequest {

    @NotNull(message = "roleId is required")
    private Long roleId;

    private List<Long> menuIds;
}
