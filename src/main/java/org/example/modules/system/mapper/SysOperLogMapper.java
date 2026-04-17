package org.example.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.modules.system.entity.SysOperLog;

@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
}