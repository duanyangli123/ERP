package org.example.modules.sales.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.sales.entity.SalOrder;

@Mapper
public interface SalOrderMapper extends BaseMapper<SalOrder> {
}
