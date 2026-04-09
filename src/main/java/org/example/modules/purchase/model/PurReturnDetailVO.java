package org.example.modules.purchase.model;

import java.util.List;
import lombok.Data;
import org.example.modules.purchase.entity.PurReturn;
import org.example.modules.purchase.entity.PurReturnItem;

@Data
public class PurReturnDetailVO {

    private PurReturn purchaseReturn;
    private List<PurReturnItem> items;
}
