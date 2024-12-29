package org.leye.maven.pinitbackend.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// 配合阿里云Oss，提供图片上传服务
public interface OssService {
    public String uploadImage(MultipartFile file) throws IOException;
    public String uploadFile(String filePath, String objectName);
    public void deleteFile(String fileUrl);
}
