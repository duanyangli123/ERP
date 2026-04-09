package org.example.modules.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.base.entity.BaseWarehouse;

@Mapper
public interface BaseWarehouseMapper extends BaseMapper<BaseWarehouse> {
}
