package org.example.modules.system.service;

import org.example.modules.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色Service接口
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据用户ID获取角色列表
     * @param userId 用户ID
     * @return 角色列表
     */
    List<SysRole> getRolesByUserId(Long userId);
}