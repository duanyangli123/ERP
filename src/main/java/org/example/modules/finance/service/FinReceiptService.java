package org.example.modules.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinReceipt;
import org.example.modules.finance.model.FinReceiptDetailVO;
import org.example.modules.finance.model.FinReceiptSaveRequest;

public interface FinReceiptService extends IService<FinReceipt> {

    Long saveReceipt(FinReceiptSaveRequest request);

    FinReceiptDetailVO getDetailById(Long id);

    boolean reverseReceipt(Long id);
}
