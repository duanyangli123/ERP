package org.example.modules.inventory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.inventory.entity.InvStockFlow;

@Mapper
public interface InvStockFlowMapper extends BaseMapper<InvStockFlow> {
}