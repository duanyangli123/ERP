package org.example.modules.system.model;

import lombok.Data;

@Data
public class OaMyTaskQuery {

    private Long pageNo;
    private Long pageSize;
    private String status;
    private String bizType;
    private String bizNo;
}
