package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseUnit;
import org.example.modules.base.mapper.BaseUnitMapper;
import org.example.modules.base.service.BaseUnitService;
import org.springframework.stereotype.Service;

@Service
public class BaseUnitServiceImpl extends ServiceImpl<BaseUnitMapper, BaseUnit> implements BaseUnitService {
}