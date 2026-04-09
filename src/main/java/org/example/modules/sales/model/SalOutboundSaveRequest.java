package org.example.modules.sales.model;

import java.util.List;
import lombok.Data;
import org.example.modules.sales.entity.SalOutbound;
import org.example.modules.sales.entity.SalOutboundItem;

@Data
public class SalOutboundSaveRequest {

    private SalOutbound outbound;
    private List<SalOutboundItem> items;
}
