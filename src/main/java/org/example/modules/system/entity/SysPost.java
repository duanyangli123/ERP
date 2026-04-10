package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.example.common.entity.BaseEntity;

/**
 * 岗位实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_post")
public class SysPost extends BaseEntity {

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 岗位名称
     */
    private String postName;

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
