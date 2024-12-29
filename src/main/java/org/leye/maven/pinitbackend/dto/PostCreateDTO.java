package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

// 用于创建新帖子时传入数据
@Getter
@Setter
public class PostCreateDTO {
    private String title;
    private String description;
    private Long userId;
    private Double latitude;
    private Double longitude;
    private MultipartFile[] images;
}
