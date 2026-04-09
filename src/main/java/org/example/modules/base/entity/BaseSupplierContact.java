package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_supplier_contact")
public class BaseSupplierContact extends BaseEntity {

    private Long supplierId;
    private String contactName;
    private String mobile;
    private String email;
    private String position;
    private Integer isDefault;
}