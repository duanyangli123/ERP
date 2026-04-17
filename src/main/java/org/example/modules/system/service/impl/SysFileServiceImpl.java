package org.example.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.modules.system.entity.SysFile;
import org.example.modules.system.mapper.SysFileMapper;
import org.example.modules.system.service.SysFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * 文件Service实现类
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    @Value("${file.upload.path:./uploads}")
    private String uploadPath;

    @Value("${file.upload.prefix:/api/system/file}")
    private String prefix;

    @Override
    public SysFile uploadFile(MultipartFile file, String category, String description) {
        return uploadFile(file, category, description, null, null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysFile uploadFile(MultipartFile file, String category, String description, String bizType, Long bizId) {
        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }

        // 获取原始文件名
        String originalFileName = file.getOriginalFilename();
        String extension = getExtension(originalFileName);
        String storageName = generateStorageName(extension);

        // 创建上传目录
        String datePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        File uploadDir = new File(uploadPath, datePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 保存文件
        File targetFile = new File(uploadDir, storageName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            throw new RuntimeException("文件保存失败", e);
        }

        // 创建文件记录
        SysFile sysFile = new SysFile();
        sysFile.setFileName(originalFileName);
        sysFile.setStorageName(storageName);
        sysFile.setFilePath("/" + datePath + "/" + storageName);
        sysFile.setFileSize(file.getSize());
        sysFile.setFileType(file.getContentType());
        sysFile.setExtension(extension);
        sysFile.setCategory(getFileCategory(extension));
        sysFile.setStorageType("local");
        sysFile.setDescription(description);
        sysFile.setBizType(bizType);
        sysFile.setBizId(bizId);
        sysFile.setStatus(1);
        sysFile.setDeleted(0);
        sysFile.setCreateTime(LocalDateTime.now());
        sysFile.setUpdateTime(LocalDateTime.now());

        this.save(sysFile);
        return sysFile;
    }

    @Override
    public IPage<SysFile> getPage(Page<SysFile> page, String category, String bizType, Long bizId) {
        LambdaQueryWrapper<SysFile> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysFile::getDeleted, 0);

        if (category != null && !category.isEmpty()) {
            wrapper.eq(SysFile::getCategory, category);
        }
        if (bizType != null && !bizType.isEmpty()) {
            wrapper.eq(SysFile::getBizType, bizType);
        }
        if (bizId != null) {
            wrapper.eq(SysFile::getBizId, bizId);
        }

        wrapper.orderByDesc(SysFile::getCreateTime);
        return this.page(page, wrapper);
    }

    @Override
    public List<SysFile> getFilesByBiz(String bizType, Long bizId) {
        return this.list(
            new LambdaQueryWrapper<SysFile>()
                .eq(SysFile::getDeleted, 0)
                .eq(SysFile::getBizType, bizType)
                .eq(SysFile::getBizId, bizId)
                .orderByAsc(SysFile::getCreateTime)
        );
    }

    @Override
    public byte[] downloadFile(Long id) {
        SysFile file = this.getById(id);
        if (file == null || file.getDeleted() == 1) {
            throw new RuntimeException("文件不存在");
        }

        try {
            Path path = Paths.get(uploadPath + file.getFilePath());
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("文件读取失败", e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteFile(Long id) {
        SysFile file = this.getById(id);
        if (file == null) {
            return false;
        }

        // 物理删除文件
        try {
            Path path = Paths.get(uploadPath + file.getFilePath());
            Files.deleteIfExists(path);
        } catch (IOException e) {
            // 忽略删除失败
        }

        // 逻辑删除
        file.setDeleted(1);
        file.setUpdateTime(LocalDateTime.now());
        return this.updateById(file);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteFiles(List<Long> ids) {
        for (Long id : ids) {
            deleteFile(id);
        }
        return true;
    }

    /**
     * 获取文件扩展名
     */
    private String getExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    /**
     * 生成存储文件名
     */
    private String generateStorageName(String extension) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        if (extension != null && !extension.isEmpty()) {
            return uuid + "." + extension;
        }
        return uuid;
    }

    /**
     * 获取文件分类
     */
    private String getFileCategory(String extension) {
        if (extension == null || extension.isEmpty()) {
            return "other";
        }
        String ext = extension.toLowerCase();
        if (ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png") || 
            ext.equals("gif") || ext.equals("bmp") || ext.equals("webp") || ext.equals("svg")) {
            return "image";
        }
        if (ext.equals("mp4") || ext.equals("avi") || ext.equals("mov") || 
            ext.equals("wmv") || ext.equals("flv") || ext.equals("mkv")) {
            return "video";
        }
        if (ext.equals("mp3") || ext.equals("wav") || ext.equals("flac") || 
            ext.equals("aac") || ext.equals("ogg")) {
            return "audio";
        }
        if (ext.equals("doc") || ext.equals("docx") || ext.equals("xls") || 
            ext.equals("xlsx") || ext.equals("ppt") || ext.equals("pptx") || 
            ext.equals("pdf") || ext.equals("txt")) {
            return "document";
        }
        return "other";
    }
}