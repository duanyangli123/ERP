package org.example.modules.system.service;

import java.util.List;
import org.example.modules.system.entity.SysRole;

public interface SysRoleService {

    List<SysRole> listAll();

    SysRole getById(Long id);

    boolean saveRole(SysRole role);
}
