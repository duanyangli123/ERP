package org.example.modules.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_material")
public class BaseMaterial extends BaseEntity {

    private String materialCode;
    private String materialName;
    private String spec;
    private String unit;
    private String category;
    private Integer safeStock;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String remark;
    private Boolean status;
}