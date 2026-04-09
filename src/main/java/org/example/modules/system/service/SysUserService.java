package org.example.modules.system.service;

import java.util.List;
import org.example.modules.system.entity.SysUser;

public interface SysUserService {

    List<SysUser> listAll();

    SysUser getById(Long id);

    boolean saveUser(SysUser user);

    List<Long> getUserRoleIds(Long userId);

    boolean assignUserRoles(Long userId, List<Long> roleIds);

    boolean resetPassword(Long userId, String newPassword);
}
