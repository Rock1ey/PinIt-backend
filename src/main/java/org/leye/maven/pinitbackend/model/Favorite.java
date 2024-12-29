package org.leye.maven.pinitbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 收藏记录的主键ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)  // 外键，指向 User 实体
    private User user;  // 用户

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)  // 外键，指向 Post 实体
    private Post post;  // 帖子

    private LocalDateTime createdAt = LocalDateTime.now();  // 收藏时间
}
