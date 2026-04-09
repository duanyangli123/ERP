package org.example.modules.purchase.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.purchase.entity.PurReceipt;
import org.example.modules.purchase.model.PurReceiptDetailVO;
import org.example.modules.purchase.model.PurReceiptSaveRequest;

public interface PurReceiptService extends IService<PurReceipt> {

    Long saveReceipt(PurReceiptSaveRequest request);

    PurReceiptDetailVO getDetailById(Long id);
}