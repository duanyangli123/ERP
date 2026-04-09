package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseCustomerAddress;
import org.example.modules.base.mapper.BaseCustomerAddressMapper;
import org.example.modules.base.service.BaseCustomerAddressService;
import org.springframework.stereotype.Service;

@Service
public class BaseCustomerAddressServiceImpl extends ServiceImpl<BaseCustomerAddressMapper, BaseCustomerAddress> implements BaseCustomerAddressService {
}