package org.example.modules.inventory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.inventory.entity.InvStockFlow;
import org.example.modules.inventory.mapper.InvStockFlowMapper;
import org.example.modules.inventory.service.InvStockFlowService;
import org.springframework.stereotype.Service;

@Service
public class InvStockFlowServiceImpl extends ServiceImpl<InvStockFlowMapper, InvStockFlow> implements InvStockFlowService {
}