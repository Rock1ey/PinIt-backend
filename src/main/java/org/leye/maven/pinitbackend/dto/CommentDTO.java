package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String text;
    private int score;
    // 发布者信息
    private String avatar;
    private String username;
    // 发布时间
    private LocalDateTime createdAt;
}
