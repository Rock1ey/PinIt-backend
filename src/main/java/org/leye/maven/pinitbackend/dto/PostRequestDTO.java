package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author leye
 * @version 1.0
 * @description: 将请求的数据封装到一个 DTO 类中，专门用来接收创建帖子的请求数据
 * @date 2024/12/24 09:23
 */
@Getter
public class PostRequestDTO {
    private String title;
    private String description;
    private Long userId;
    private MultipartFile[] files;
}

