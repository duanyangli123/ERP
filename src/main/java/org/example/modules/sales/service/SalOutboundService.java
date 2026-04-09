package org.example.modules.sales.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.sales.entity.SalOutbound;
import org.example.modules.sales.model.SalOutboundDetailVO;
import org.example.modules.sales.model.SalOutboundSaveRequest;

public interface SalOutboundService extends IService<SalOutbound> {

    Long saveOutbound(SalOutboundSaveRequest request);

    SalOutboundDetailVO getDetailById(Long id);
}
