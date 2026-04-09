package org.example.modules.purchase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseDocItemEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pur_return_item")
public class PurReturnItem extends BaseDocItemEntity {

    private Long returnId;
    private Long orderItemId;
    private Long materialId;
    private String batchNo;
    private BigDecimal qty;
    private BigDecimal price;
    private BigDecimal amount;
}

