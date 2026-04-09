package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseSupplier;
import org.example.modules.base.mapper.BaseSupplierMapper;
import org.example.modules.base.service.BaseSupplierService;
import org.springframework.stereotype.Service;

@Service
public class BaseSupplierServiceImpl extends ServiceImpl<BaseSupplierMapper, BaseSupplier> implements BaseSupplierService {
}
