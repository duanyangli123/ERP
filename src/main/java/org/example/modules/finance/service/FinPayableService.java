package org.example.modules.finance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinPayable;

public interface FinPayableService extends IService<FinPayable> {

    IPage<FinPayable> pagePayable(Page<FinPayable> page, FinPayable query);

    FinPayable getPayableById(Long id);

    Long savePayable(FinPayable payable);

    boolean updatePayable(FinPayable payable);

    boolean deletePayable(Long id);
}