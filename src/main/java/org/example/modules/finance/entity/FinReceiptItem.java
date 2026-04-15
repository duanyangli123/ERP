package org.example.modules.finance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fin_receipt_item")
public class FinReceiptItem extends BaseEntity {

    private Long receiptId;
    private Long receivableId;
    private String receivableNo;
    private BigDecimal amount;
    private String remark;
}