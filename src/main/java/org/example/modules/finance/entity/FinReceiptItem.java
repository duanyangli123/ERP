package org.example.modules.finance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fin_receipt_item")
public class FinReceiptItem extends BaseEntity {

    private Long receiptId;
    private Long receivableId;
    private BigDecimal writeoffAmount;
}
