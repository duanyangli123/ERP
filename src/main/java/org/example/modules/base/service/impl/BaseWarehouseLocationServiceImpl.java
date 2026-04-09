package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseWarehouseLocation;
import org.example.modules.base.mapper.BaseWarehouseLocationMapper;
import org.example.modules.base.service.BaseWarehouseLocationService;
import org.springframework.stereotype.Service;

@Service
public class BaseWarehouseLocationServiceImpl extends ServiceImpl<BaseWarehouseLocationMapper, BaseWarehouseLocation> implements BaseWarehouseLocationService {
}