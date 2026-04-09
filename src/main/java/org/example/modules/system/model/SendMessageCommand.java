package org.example.modules.system.model;

import lombok.Data;

@Data
public class SendMessageCommand {

    private Long receiverId;
    private String title;
    private String content;
    private String bizType;
    private Long bizId;
    private String bizNo;
    private Integer sendInternal;
    private Integer sendEmail;
    private Integer sendSms;
    private Integer sendIm;
}
