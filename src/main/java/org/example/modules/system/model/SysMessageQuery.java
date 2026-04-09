package org.example.modules.system.model;

import lombok.Data;

@Data
public class SysMessageQuery {

    private Long pageNo;
    private Long pageSize;
    private Integer readStatus;
    private String bizType;
    private String channel;
    private String sendStatus;
    private String keyword;
}