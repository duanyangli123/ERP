package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.example.common.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * 数据权限范围：1-全部，2-自定义，3-本部门，4-本部门及以下，5-仅本人（数据库中不存在）
     */
    @TableField(exist = false)
    private Integer dataScope;

    /**
     * 自定义数据权限部门ID集合（数据库中不存在）
     */
    @TableField(exist = false)
    private String dataScopeDeptIds;

    /**
     * 获取数据权限部门ID集合
     */
    public Set<Long> getDataScopeDeptIdSet() {
        if (dataScopeDeptIds == null || dataScopeDeptIds.isEmpty()) {
            return new HashSet<>();
        }
        Set<Long> set = new HashSet<>();
        for (String id : dataScopeDeptIds.split(",")) {
            if (id.trim().matches("\\d+")) {
                set.add(Long.parseLong(id.trim()));
            }
        }
        return set;
    }
}
