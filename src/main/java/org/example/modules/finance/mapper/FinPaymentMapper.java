package org.example.modules.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.finance.entity.FinPayment;

@Mapper
public interface FinPaymentMapper extends BaseMapper<FinPayment> {
}
