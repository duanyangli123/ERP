package org.example.modules.system.service;

import java.util.List;
import org.example.modules.system.entity.SysDept;

public interface SysDeptService {

    List<SysDept> listAll();

    SysDept getById(Long id);

    boolean saveDept(SysDept dept);
}