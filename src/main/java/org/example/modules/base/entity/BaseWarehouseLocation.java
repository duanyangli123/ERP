package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_warehouse_location")
public class BaseWarehouseLocation extends BaseEntity {

    private Long warehouseId;
    private Long areaId;
    private String locationCode;
    private String locationName;
    private Integer status;
}