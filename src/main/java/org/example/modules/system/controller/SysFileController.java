package org.example.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.servlet.http.HttpServletResponse;
import org.example.common.model.ApiResponse;
import org.example.modules.system.entity.SysFile;
import org.example.modules.system.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 文件Controller
 */
@RestController
@RequestMapping("/api/system/file")
public class SysFileController {

    @Autowired
    private SysFileService fileService;

    @Value("${file.upload.prefix:/api/system/file}")
    private String prefix;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public ApiResponse<SysFile> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "description", required = false) String description) {

        try {
            SysFile sysFile = fileService.uploadFile(file, category, description);
            // 返回完整的访问URL
            sysFile.setFilePath(prefix + "/view/" + sysFile.getId());
            return ApiResponse.success(sysFile);
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 上传文件（带业务关联）
     */
    @PostMapping("/upload/biz")
    public ApiResponse<SysFile> uploadBiz(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "bizType", required = false) String bizType,
            @RequestParam(value = "bizId", required = false) Long bizId) {

        try {
            SysFile sysFile = fileService.uploadFile(file, category, description, bizType, bizId);
            sysFile.setFilePath(prefix + "/view/" + sysFile.getId());
            return ApiResponse.success(sysFile);
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }

    /**
     * 分页查询文件列表
     */
    @GetMapping("/page")
    public ApiResponse<IPage<SysFile>> getPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String bizType,
            @RequestParam(required = false) Long bizId) {

        Page<SysFile> page = new Page<>(pageNum, pageSize);
        IPage<SysFile> result = fileService.getPage(page, category, bizType, bizId);
        return ApiResponse.success(result);
    }

    /**
     * 根据业务类型和业务ID获取文件列表
     */
    @GetMapping("/list")
    public ApiResponse<List<SysFile>> getList(
            @RequestParam String bizType,
            @RequestParam Long bizId) {

        List<SysFile> list = fileService.getFilesByBiz(bizType, bizId);
        return ApiResponse.success(list);
    }

    /**
     * 查看文件
     */
    @GetMapping("/view/{id}")
    public void view(@PathVariable Long id, HttpServletResponse response) {
        try {
            byte[] data = fileService.downloadFile(id);
            SysFile file = fileService.getById(id);

            response.setContentType(file.getFileType());
            response.setHeader("Content-Disposition", "inline; filename=" + file.getFileName());
            response.getOutputStream().write(data);
            response.getOutputStream().flush();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    /**
     * 下载文件
     */
    @GetMapping("/download/{id}")
    public void download(@PathVariable Long id, HttpServletResponse response) {
        try {
            byte[] data = fileService.downloadFile(id);
            SysFile file = fileService.getById(id);

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(file.getFileName(), "UTF-8"));
            response.getOutputStream().write(data);
            response.getOutputStream().flush();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    /**
     * 删除文件
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        fileService.deleteFile(id);
        return ApiResponse.success(null);
    }

    /**
     * 批量删除文件
     */
    @DeleteMapping("/batch")
    public ApiResponse<Void> deleteBatch(@RequestBody List<Long> ids) {
        fileService.deleteFiles(ids);
        return ApiResponse.success(null);
    }
}