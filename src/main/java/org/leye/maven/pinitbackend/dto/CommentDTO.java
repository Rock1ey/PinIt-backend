package org.leye.maven.pinitbackend.dto;

import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 21:20
 */
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
