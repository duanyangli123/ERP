package org.example.modules.system.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OaProcessNodeSaveDTO {

    private Long id;
    private Integer nodeNo;
    private String nodeName;
    private String approverType;
    private Long approverId;
    private String approverName;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String remark;
}