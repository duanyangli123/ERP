package org.example.modules.system.service.impl;

import org.example.modules.system.entity.SysPost;
import org.example.modules.system.mapper.SysPostMapper;
import org.example.modules.system.service.SysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 岗位Service实现类
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {
}