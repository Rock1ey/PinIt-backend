package org.leye.maven.pinitbackend.service;


/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 19:12
 */
public interface OssService {
    public String uploadFile(String filePath, String objectName);
    public void deleteFile(String fileUrl);
}
