package org.example.modules.inventory.service.impl;

import org.example.modules.inventory.entity.InvStock;
import org.example.modules.inventory.mapper.InvStockMapper;
import org.example.modules.inventory.service.InvStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InvStockServiceImpl extends ServiceImpl<InvStockMapper, InvStock> implements InvStockService {
}