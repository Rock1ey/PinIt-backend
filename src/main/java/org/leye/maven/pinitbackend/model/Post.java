package org.leye.maven.pinitbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: Post实体类，存储用户发布的帖子信息
 * @date 2024/12/23 21:56
 */
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置主键自增策略
    private Long id;
    private String title; // 帖子标题
    private String description; // 帖子描述
    // private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 外键
    @JsonManagedReference
    private User user; // 发布者

    @ManyToMany(mappedBy = "favoritePosts")  // 指定反向关系
    private List<User> usersWhoFavorited;  // 收藏该帖子的用户

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();  // 一对多关系，Post 包含多个 Image
}
