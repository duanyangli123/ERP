package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseWarehouse;
import org.example.modules.base.mapper.BaseWarehouseMapper;
import org.example.modules.base.service.BaseWarehouseService;
import org.springframework.stereotype.Service;

@Service
public class BaseWarehouseServiceImpl extends ServiceImpl<BaseWarehouseMapper, BaseWarehouse> implements BaseWarehouseService {
}
