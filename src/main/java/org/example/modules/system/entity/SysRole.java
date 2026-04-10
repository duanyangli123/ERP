package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.example.common.entity.BaseEntity;

/**
 * 角色实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BaseEntity {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：0-禁用，1-正常
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;
}
