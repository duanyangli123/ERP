package org.example.modules.finance.model;

import java.util.List;
import lombok.Data;
import org.example.modules.finance.entity.FinReceipt;
import org.example.modules.finance.entity.FinReceiptItem;

@Data
public class FinReceiptDetailVO {

    private FinReceipt receipt;
    private List<FinReceiptItem> items;
}
