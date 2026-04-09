package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName("sys_role_menu")
public class SysRoleMenu {

    private Long id;
    private Long tenantId;
    private Long roleId;
    private Long menuId;
    private LocalDateTime createdTime;
    private Integer deleted;
}
