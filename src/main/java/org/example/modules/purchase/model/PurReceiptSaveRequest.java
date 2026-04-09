package org.example.modules.purchase.model;

import java.util.List;
import lombok.Data;
import org.example.modules.purchase.entity.PurReceipt;
import org.example.modules.purchase.entity.PurReceiptItem;

@Data
public class PurReceiptSaveRequest {

    private PurReceipt receipt;
    private List<PurReceiptItem> items;
}