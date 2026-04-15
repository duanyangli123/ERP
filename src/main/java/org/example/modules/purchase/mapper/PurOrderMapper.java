package org.example.modules.purchase.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.purchase.entity.PurOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface PurOrderMapper extends BaseMapper<PurOrder> {
}