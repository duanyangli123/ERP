package org.example.modules.finance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinReceipt;
import org.example.modules.finance.model.FinReceiptDetailVO;
import org.example.modules.finance.model.FinReceiptSaveRequest;

public interface FinReceiptService extends IService<FinReceipt> {

    IPage<FinReceipt> pageReceipt(Page<FinReceipt> page, FinReceipt query);

    FinReceipt getReceiptById(Long id);

    Long saveReceipt(FinReceiptSaveRequest request);

    boolean updateReceipt(FinReceiptSaveRequest request);

    boolean deleteReceipt(Long id);

    FinReceiptDetailVO getDetailById(Long id);

    boolean reverseReceipt(Long id);
}