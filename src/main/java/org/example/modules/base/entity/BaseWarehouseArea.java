package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_warehouse_area")
public class BaseWarehouseArea extends BaseEntity {

    private Long warehouseId;
    private String areaCode;
    private String areaName;
    private Integer status;
}