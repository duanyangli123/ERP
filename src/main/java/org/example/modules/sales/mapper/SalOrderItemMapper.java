package org.example.modules.sales.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.sales.entity.SalOrderItem;

@Mapper
public interface SalOrderItemMapper extends BaseMapper<SalOrderItem> {
}