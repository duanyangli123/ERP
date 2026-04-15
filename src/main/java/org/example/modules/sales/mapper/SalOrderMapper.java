package org.example.modules.sales.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.sales.entity.SalOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface SalOrderMapper extends BaseMapper<SalOrder> {
}