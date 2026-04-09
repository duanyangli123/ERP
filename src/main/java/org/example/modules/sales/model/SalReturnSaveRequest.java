package org.example.modules.sales.model;

import java.util.List;
import lombok.Data;
import org.example.modules.sales.entity.SalReturn;
import org.example.modules.sales.entity.SalReturnItem;

@Data
public class SalReturnSaveRequest {

    private SalReturn salesReturn;
    private List<SalReturnItem> items;
}
