package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.entity.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oa_process_def")
public class OaProcessDef extends BaseEntity {

    private String processCode;
    private String processName;
    private String bizType;
    private Integer status;
    private Integer notifyInternal;
    private Integer notifyEmail;
    private Integer notifySms;
    private Integer notifyIm;
}
