package org.example.modules.system.service;

import java.util.List;
import org.example.modules.system.entity.SysPost;

public interface SysPostService {

    List<SysPost> listAll();

    SysPost getById(Long id);

    boolean savePost(SysPost post);
}