package org.example.modules.system.service;

import org.example.modules.system.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 部门Service接口
 */
public interface SysDeptService extends IService<SysDept> {
    
    /**
     * 获取所有部门列表
     */
    List<SysDept> getAllDepts();
    
    /**
     * 获取部门树形列表
     */
    List<SysDept> getDeptTree();
}