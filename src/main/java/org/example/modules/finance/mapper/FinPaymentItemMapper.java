package org.example.modules.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.finance.entity.FinPaymentItem;

@Mapper
public interface FinPaymentItemMapper extends BaseMapper<FinPaymentItem> {
}
