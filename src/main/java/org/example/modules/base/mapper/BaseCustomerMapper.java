package org.example.modules.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.base.entity.BaseCustomer;

@Mapper
public interface BaseCustomerMapper extends BaseMapper<BaseCustomer> {
}
