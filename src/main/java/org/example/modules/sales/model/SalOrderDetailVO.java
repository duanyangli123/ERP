package org.example.modules.sales.model;

import java.util.List;
import lombok.Data;
import org.example.modules.sales.entity.SalOrder;
import org.example.modules.sales.entity.SalOrderItem;

@Data
public class SalOrderDetailVO {

    private SalOrder order;
    private List<SalOrderItem> items;
}