package org.example.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.modules.system.entity.SysFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件Service接口
 */
public interface SysFileService extends IService<SysFile> {

    /**
     * 上传文件
     * @param file 上传的文件
     * @param category 文件分类
     * @param description 文件描述
     * @return 文件信息
     */
    SysFile uploadFile(MultipartFile file, String category, String description);

    /**
     * 上传文件（带业务关联）
     * @param file 上传的文件
     * @param category 文件分类
     * @param description 文件描述
     * @param bizType 业务类型
     * @param bizId 业务ID
     * @return 文件信息
     */
    SysFile uploadFile(MultipartFile file, String category, String description, String bizType, Long bizId);

    /**
     * 分页查询文件列表
     * @param page 分页参数
     * @param category 文件分类
     * @param bizType 业务类型
     * @param bizId 业务ID
     * @return 分页结果
     */
    IPage<SysFile> getPage(Page<SysFile> page, String category, String bizType, Long bizId);

    /**
     * 根据业务类型和业务ID获取文件列表
     * @param bizType 业务类型
     * @param bizId 业务ID
     * @return 文件列表
     */
    List<SysFile> getFilesByBiz(String bizType, Long bizId);

    /**
     * 下载文件
     * @param id 文件ID
     * @return 字节数组
     */
    byte[] downloadFile(Long id);

    /**
     * 删除文件
     * @param id 文件ID
     * @return 是否成功
     */
    boolean deleteFile(Long id);

    /**
     * 批量删除文件
     * @param ids 文件ID列表
     * @return 是否成功
     */
    boolean deleteFiles(List<Long> ids);
}