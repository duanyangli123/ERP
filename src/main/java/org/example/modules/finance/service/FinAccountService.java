package org.example.modules.finance.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.finance.entity.FinAccount;

public interface FinAccountService extends IService<FinAccount> {

    IPage<FinAccount> pageAccount(Page<FinAccount> page, FinAccount query);

    FinAccount getAccountById(Long id);

    Long saveAccount(FinAccount account);

    boolean updateAccount(FinAccount account);

    boolean deleteAccount(Long id);
}