package org.example.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.modules.system.entity.SysDept;

@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 根据用户ID查询所属部门
     */
    @Select("SELECT d.* FROM sys_dept d " +
            "LEFT JOIN sys_user u ON u.dept_id = d.id " +
            "WHERE u.id = #{userId} AND d.deleted = 0")
    SysDept selectOneByUserId(Long userId);
}