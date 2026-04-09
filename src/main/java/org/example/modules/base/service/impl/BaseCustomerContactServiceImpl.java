package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseCustomerContact;
import org.example.modules.base.mapper.BaseCustomerContactMapper;
import org.example.modules.base.service.BaseCustomerContactService;
import org.springframework.stereotype.Service;

@Service
public class BaseCustomerContactServiceImpl extends ServiceImpl<BaseCustomerContactMapper, BaseCustomerContact> implements BaseCustomerContactService {
}