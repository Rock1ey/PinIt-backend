package org.leye.maven.pinitbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leye
 * @version 1.0
 * @description: Image 实体类表示一个图片，它会持有一个 post_id 外键，关联到 Post 实体
 * @date 2024/12/24 03:40
 */
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
    private Post post;

    // 其他字段和 Getter/Setter
}

