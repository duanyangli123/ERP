package org.example.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文件实体
 */
@Data
@TableName("sys_file")
public class SysFile {

    /**
     * 文件ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文件名（原始文件名）
     */
    private String fileName;

    /**
     * 文件存储名（生成的文件名）
     */
    private String storageName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件大小（字节）
     */
    private Long fileSize;

    /**
     * 文件类型（MIME类型）
     */
    private String fileType;

    /**
     * 文件扩展名
     */
    private String extension;

    /**
     * 文件分类：image-图片、video-视频、audio-音频、document-文档、other-其他
     */
    private String category;

    /**
     * 存储方式：local-本地、oss-对象存储、minio-MinIO
     */
    private String storageType;

    /**
     * 文件说明
     */
    private String description;

    /**
     * 业务类型（用于关联业务）
     */
    private String bizType;

    /**
     * 业务ID
     */
    private Long bizId;

    /**
     * 上传用户ID
     */
    private Long uploadUserId;

    /**
     * 上传用户名称
     */
    private String uploadUserName;

    /**
     * 状态：0-禁用，1-正常
     */
    private Integer status;

    /**
     * 删除标志：0-未删除，1-已删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}