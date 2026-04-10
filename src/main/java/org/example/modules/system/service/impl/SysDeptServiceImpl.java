package org.example.modules.system.service.impl;

import org.example.modules.system.entity.SysDept;
import org.example.modules.system.mapper.SysDeptMapper;
import org.example.modules.system.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门Service实现类
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<SysDept> getAllDepts() {
        return list();
    }

    @Override
    public List<SysDept> getDeptTree() {
        List<SysDept> allDepts = list();
        return buildDeptTree(allDepts, 0L);
    }

    /**
     * 构建部门树
     */
    private List<SysDept> buildDeptTree(List<SysDept> depts, Long parentId) {
        return depts.stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .collect(Collectors.toList());
    }
}