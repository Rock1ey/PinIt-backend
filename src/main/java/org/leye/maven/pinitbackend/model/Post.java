package org.leye.maven.pinitbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 设置主键自增策略
    private Long id;
    private String title; // 帖子标题
    private String description; // 帖子描述

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // 外键
    @JsonManagedReference
    private User user; // 发布者

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Favorite> favorites;  // 帖子被哪些用户收藏

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();  // 一对多关系，Post 包含多个 Image

    @Embedded
    private Location location;

    private LocalDateTime createdAt = LocalDateTime.now();
}
