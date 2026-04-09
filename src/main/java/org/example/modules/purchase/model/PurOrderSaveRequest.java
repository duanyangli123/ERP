package org.example.modules.purchase.model;

import java.util.List;
import lombok.Data;
import org.example.modules.purchase.entity.PurOrder;
import org.example.modules.purchase.entity.PurOrderItem;

@Data
public class PurOrderSaveRequest {

    private PurOrder order;
    private List<PurOrderItem> items;
}