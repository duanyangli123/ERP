package org.example.modules.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.base.entity.BaseMaterial;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface BaseMaterialMapper extends BaseMapper<BaseMaterial> {
}