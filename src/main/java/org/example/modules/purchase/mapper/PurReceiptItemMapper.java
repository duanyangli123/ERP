package org.example.modules.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.purchase.entity.PurReceiptItem;

@Mapper
public interface PurReceiptItemMapper extends BaseMapper<PurReceiptItem> {
}