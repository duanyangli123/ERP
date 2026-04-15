package org.example.modules.base.service.impl;

import org.example.modules.base.entity.BaseCustomer;
import org.example.modules.base.mapper.BaseCustomerMapper;
import org.example.modules.base.service.BaseCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseCustomerServiceImpl extends ServiceImpl<BaseCustomerMapper, BaseCustomer> implements BaseCustomerService {
}