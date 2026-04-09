package org.example.modules.system.model;

import java.util.List;
import lombok.Data;
import org.example.modules.system.entity.OaProcessDef;
import org.example.modules.system.entity.OaProcessNode;

@Data
public class OaProcessDefDetailVO {

    private OaProcessDef processDef;
    private List<OaProcessNode> nodes;
}
