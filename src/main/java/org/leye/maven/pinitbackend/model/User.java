package org.leye.maven.pinitbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: 用户实体类
 * @date 2024/12/24 04:27
 */
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;
    // private String email;
    private String bio;
    private String avatar;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Post> posts; // 用户发布的帖子

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_post_favorites", // 关联表的名字
            joinColumns = @JoinColumn(name = "user_id"), // 用户外键
            inverseJoinColumns = @JoinColumn(name = "post_id") // 帖子外键
    )
    private List<Post> favoritePosts; // 用户收藏的帖子
}
