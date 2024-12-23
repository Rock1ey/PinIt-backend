package org.leye.maven.pinitbackend.dto;

import lombok.Setter;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 04:04
 */
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private Long userid;
    private List<String> imageUrls;  // 存储图片的 URL
}
