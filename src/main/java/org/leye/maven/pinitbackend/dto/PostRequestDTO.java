package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

// 封装更新帖子的请求数据
@Getter
public class PostRequestDTO {
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Double latitude;
    private Double longitude;
    private MultipartFile[] files;
}

