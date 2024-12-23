package org.leye.maven.pinitbackend.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author leye
 * @version 1.0
 * @description: 将图片上传到阿里云 OSS 等逻辑实现
 * @date 2024/12/24 03:47
 */
@Service
public class OssService {

    private static final String ENDPOINT = "<your-oss-endpoint>";
    private static final String ACCESS_KEY_ID = "<your-access-key-id>";
    private static final String ACCESS_KEY_SECRET = "<your-access-key-secret>";
    private static final String BUCKET_NAME = "<your-bucket-name>";

    private OSS ossClient;

    public OssService() {
        // 初始化 OSS 客户端
        ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    public String uploadFile(String filePath, String objectName) {
        // 上传文件
        ossClient.putObject(new PutObjectRequest(BUCKET_NAME, objectName, new File(filePath)));

        // 获取上传的文件 URL
        String fileUrl = "https://" + BUCKET_NAME + "." + ENDPOINT + "/" + objectName;

        // 关闭 OSS 客户端
        ossClient.shutdown();

        return fileUrl;
    }
}
