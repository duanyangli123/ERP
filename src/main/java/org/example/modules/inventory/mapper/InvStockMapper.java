package org.example.modules.inventory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.inventory.entity.InvStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface InvStockMapper extends BaseMapper<InvStock> {
}