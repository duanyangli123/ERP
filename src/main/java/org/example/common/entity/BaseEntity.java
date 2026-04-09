package org.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BaseEntity implements Serializable {

    private Long id;
    private Long tenantId;
    private String remark;
    private Long createdBy;
    private String createdName;
    private LocalDateTime createdTime;
    private Long updatedBy;
    private String updatedName;
    private LocalDateTime updatedTime;

    @TableLogic
    private Integer deleted;
}
