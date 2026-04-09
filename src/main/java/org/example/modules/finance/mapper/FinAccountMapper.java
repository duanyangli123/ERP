package org.example.modules.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.finance.entity.FinAccount;

@Mapper
public interface FinAccountMapper extends BaseMapper<FinAccount> {
}
