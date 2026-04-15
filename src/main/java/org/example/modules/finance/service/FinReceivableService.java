package org.example.modules.finance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinReceivable;

public interface FinReceivableService extends IService<FinReceivable> {

    IPage<FinReceivable> pageReceivable(Page<FinReceivable> page, FinReceivable query);

    FinReceivable getReceivableById(Long id);

    Long saveReceivable(FinReceivable receivable);

    boolean updateReceivable(FinReceivable receivable);

    boolean deleteReceivable(Long id);
}