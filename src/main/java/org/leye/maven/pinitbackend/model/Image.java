package org.leye.maven.pinitbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Image 实体类表示一个图片，它会持有一个 post_id 外键，关联到 Post 实体
@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;  // 图片的 URL

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)  // 外键，指向 Post
    @JsonBackReference  // 反向引用，防止无限递归
    private Post post;
}

