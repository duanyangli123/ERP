package org.example.modules.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinPayable;
import org.example.modules.purchase.entity.PurOrder;

public interface FinPayableService extends IService<FinPayable> {

    Long savePayable(FinPayable payable);

    void syncFromPurchaseOrder(PurOrder order);
}
