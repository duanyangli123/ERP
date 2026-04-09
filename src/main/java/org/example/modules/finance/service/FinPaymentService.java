package org.example.modules.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinPayment;
import org.example.modules.finance.model.FinPaymentDetailVO;
import org.example.modules.finance.model.FinPaymentSaveRequest;

public interface FinPaymentService extends IService<FinPayment> {

    Long savePayment(FinPaymentSaveRequest request);

    FinPaymentDetailVO getDetailById(Long id);

    boolean reversePayment(Long id);
}
