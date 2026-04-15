package org.example.modules.finance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.modules.finance.entity.FinAccount;
import org.example.modules.finance.mapper.FinAccountMapper;
import org.example.modules.finance.service.FinAccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class FinAccountServiceImpl extends ServiceImpl<FinAccountMapper, FinAccount> implements FinAccountService {

    @Override
    public IPage<FinAccount> pageAccount(Page<FinAccount> page, FinAccount query) {
        LambdaQueryWrapper<FinAccount> wrapper = new LambdaQueryWrapper<>();
        if (query != null) {
            wrapper.like(StringUtils.hasText(query.getAccountCode()), FinAccount::getAccountCode, query.getAccountCode())
                   .like(StringUtils.hasText(query.getAccountName()), FinAccount::getAccountName, query.getAccountName())
                   .like(StringUtils.hasText(query.getAccountType()), FinAccount::getAccountType, query.getAccountType())
                   .eq(query.getStatus() != null, FinAccount::getStatus, query.getStatus());
        }
        wrapper.orderByDesc(FinAccount::getCreatedTime);
        return page(page, wrapper);
    }

    @Override
    public FinAccount getAccountById(Long id) {
        return getById(id);
    }

    @Override
    public Long saveAccount(FinAccount account) {
        save(account);
        return account.getId();
    }

    @Override
    public boolean updateAccount(FinAccount account) {
        return updateById(account);
    }

    @Override
    public boolean deleteAccount(Long id) {
        return removeById(id);
    }
}