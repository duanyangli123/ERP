package org.example.modules.system.model;

import java.util.List;
import lombok.Data;
import org.example.modules.system.entity.OaProcessDef;

@Data
public class OaProcessDefSaveRequest {

    private OaProcessDef processDef;
    private List<OaProcessNodeSaveDTO> nodes;
}
