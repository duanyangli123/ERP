package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_customer")
public class BaseCustomer extends BaseEntity {

    private String customerCode;
    private String customerName;
    private String shortName;
    private Integer customerType;
    private String contactPerson;
    private String phone;
    private String mobile;
    private String email;
    private String fax;
    private String website;
    private String country;
    private String province;
    private String city;
    private String address;
    private String remark;
    private Boolean status;
}