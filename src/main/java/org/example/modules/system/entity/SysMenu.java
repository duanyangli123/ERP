package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.example.common.entity.BaseEntity;

/**
 * 菜单实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu extends BaseEntity {

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型：0-目录，1-菜单，2-按钮
     */
    private Integer menuType;

    /**
     * 状态：0-禁用，1-正常
     */
    private Boolean status;

    /**
     * 是否可见
     */
    private Boolean visible;

    /**
     * 是否缓存
     */
    private Boolean keepAlive;

    /**
     * 是否总是显示
     */
    private Boolean alwaysShow;
}
