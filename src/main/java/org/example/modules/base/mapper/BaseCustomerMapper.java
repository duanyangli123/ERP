package org.example.modules.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.modules.base.entity.BaseCustomer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface BaseCustomerMapper extends BaseMapper<BaseCustomer> {
}