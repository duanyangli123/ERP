package org.example.modules.system.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SysMenuTreeVO {

    private Long id;
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
    private List<SysMenuTreeVO> children = new ArrayList<>();
}
