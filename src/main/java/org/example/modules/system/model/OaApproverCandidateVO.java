package org.example.modules.system.model;

import lombok.Data;

@Data
public class OaApproverCandidateVO {

    private String candidateType;
    private Long candidateId;
    private String candidateCode;
    private String candidateName;
    private Long deptId;
    private String deptName;
    private Long postId;
    private String postName;
    private Integer memberCount;
}