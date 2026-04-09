package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseWarehouseArea;
import org.example.modules.base.mapper.BaseWarehouseAreaMapper;
import org.example.modules.base.service.BaseWarehouseAreaService;
import org.springframework.stereotype.Service;

@Service
public class BaseWarehouseAreaServiceImpl extends ServiceImpl<BaseWarehouseAreaMapper, BaseWarehouseArea> implements BaseWarehouseAreaService {
}