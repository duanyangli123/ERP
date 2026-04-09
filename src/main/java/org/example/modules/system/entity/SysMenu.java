package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu extends BaseEntity {

    private Long parentId;
    private String menuName;
    private String menuType;
    private String routePath;
    private String componentPath;
    private String permCode;
    private String icon;
    private Integer sortNo;
    private Integer visible;
    private Integer status;
}
