package org.example.modules.finance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.finance.entity.FinAccount;
import org.example.modules.finance.mapper.FinAccountMapper;
import org.example.modules.finance.service.FinAccountService;
import org.springframework.stereotype.Service;

@Service
public class FinAccountServiceImpl extends ServiceImpl<FinAccountMapper, FinAccount> implements FinAccountService {
}