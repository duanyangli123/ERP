package org.example.modules.finance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinPayment;
import org.example.modules.finance.model.FinPaymentDetailVO;
import org.example.modules.finance.model.FinPaymentSaveRequest;

public interface FinPaymentService extends IService<FinPayment> {

    IPage<FinPayment> pagePayment(Page<FinPayment> page, FinPayment query);

    FinPayment getPaymentById(Long id);

    Long savePayment(FinPaymentSaveRequest request);

    boolean updatePayment(FinPaymentSaveRequest request);

    boolean deletePayment(Long id);

    FinPaymentDetailVO getDetailById(Long id);

    boolean reversePayment(Long id);
}