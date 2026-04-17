package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseSimpleEntity;

/**
 * 用户角色关联实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole extends BaseSimpleEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}