package org.example.modules.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinReceivable;
import org.example.modules.sales.entity.SalOrder;

public interface FinReceivableService extends IService<FinReceivable> {

    Long saveReceivable(FinReceivable receivable);

    void syncFromSalesOrder(SalOrder order);
}
