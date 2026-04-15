package org.example.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.system.entity.SysDept;
import org.example.modules.system.mapper.SysDeptMapper;
import org.example.modules.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<SysDept> getAllDepts() {
        return list();
    }

    @Override
    public List<SysDept> getDeptTree() {
        return list();
    }
}