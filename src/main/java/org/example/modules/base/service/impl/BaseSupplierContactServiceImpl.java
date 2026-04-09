package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseSupplierContact;
import org.example.modules.base.mapper.BaseSupplierContactMapper;
import org.example.modules.base.service.BaseSupplierContactService;
import org.springframework.stereotype.Service;

@Service
public class BaseSupplierContactServiceImpl extends ServiceImpl<BaseSupplierContactMapper, BaseSupplierContact> implements BaseSupplierContactService {
}