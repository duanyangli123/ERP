package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_warehouse")
public class BaseWarehouse extends BaseEntity {

    private String warehouseCode;
    private String warehouseName;
    private String shortName;
    private Integer warehouseType;
    private String province;
    private String city;
    private String address;
    private String manager;
    private String phone;
    private String remark;
    private Boolean status;
}