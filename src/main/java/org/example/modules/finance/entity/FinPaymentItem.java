package org.example.modules.finance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("fin_payment_item")
public class FinPaymentItem extends BaseEntity {

    private Long paymentId;
    private Long payableId;
    private BigDecimal writeoffAmount;
}
