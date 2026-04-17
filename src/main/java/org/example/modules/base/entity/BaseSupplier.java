package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_supplier")
public class BaseSupplier extends BaseEntity {

    private String supplierCode;
    private String supplierName;
    private String shortName;
    private Integer supplierType;
    private String contactPerson;
    private String phone;
    private String mobile;
    private String email;
    private String fax;
    private String country;
    private String province;
    private String city;
    private String address;
    private String bankName;
    private String bankAccount;
    private String taxNumber;
    private String remark;
    private Boolean status;
}