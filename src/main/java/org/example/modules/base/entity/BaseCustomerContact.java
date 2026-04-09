package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_customer_contact")
public class BaseCustomerContact extends BaseEntity {

    private Long customerId;
    private String contactName;
    private String gender;
    private String mobile;
    private String phone;
    private String email;
    private String position;
    private Integer isDefault;
}