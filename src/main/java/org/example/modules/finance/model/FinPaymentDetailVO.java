package org.example.modules.finance.model;

import java.util.List;
import lombok.Data;
import org.example.modules.finance.entity.FinPayment;
import org.example.modules.finance.entity.FinPaymentItem;

@Data
public class FinPaymentDetailVO {

    private FinPayment payment;
    private List<FinPaymentItem> items;
}
