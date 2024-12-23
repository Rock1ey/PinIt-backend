package org.leye.maven.pinitbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author leye
 * @version 1.0
 * @description: Post实体类，存储用户发布的帖子信息
 * @date 2024/12/23 21:56
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String imageUrl;
    private Long userId;
    // getters and setters
}
