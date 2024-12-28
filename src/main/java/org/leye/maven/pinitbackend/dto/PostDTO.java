package org.leye.maven.pinitbackend.dto;

import lombok.Setter;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: 供前端展示 Post 的各数据
 * @date 2024/12/24 04:04
 */
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private List<String> imageUrls;  // 存储图片的 URL
    // 发布者相关数据（在帖子页仅展示昵称和头像）
    private Long userid;
    private String username;
    private String avatarUrl;
    // 位置数据
    private Double latitude;
    private Double longitude;
}
