package org.example.modules.system.model;

import java.util.List;
import lombok.Data;
import org.example.modules.system.entity.OaProcessInstance;
import org.example.modules.system.entity.OaProcessTask;

@Data
public class OaProcessDetailVO {

    private OaProcessInstance instance;
    private List<OaProcessTask> tasks;
}
