package org.example.modules.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.base.entity.BaseSupplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface BaseSupplierMapper extends BaseMapper<BaseSupplier> {
}