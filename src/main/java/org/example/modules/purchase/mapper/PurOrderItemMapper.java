package org.example.modules.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.purchase.entity.PurOrderItem;

@Mapper
public interface PurOrderItemMapper extends BaseMapper<PurOrderItem> {
}