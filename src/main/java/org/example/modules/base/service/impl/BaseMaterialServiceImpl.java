package org.example.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.base.entity.BaseMaterial;
import org.example.modules.base.mapper.BaseMaterialMapper;
import org.example.modules.base.service.BaseMaterialService;
import org.springframework.stereotype.Service;

@Service
public class BaseMaterialServiceImpl extends ServiceImpl<BaseMaterialMapper, BaseMaterial> implements BaseMaterialService {
}
