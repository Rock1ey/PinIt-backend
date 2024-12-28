package org.leye.maven.pinitbackend.dto;

import lombok.Getter;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 21:28
 */
@Getter
public class CommentRequestDTO {
    private Long id;
    private String text;
    private int score;
    private Long userId;
}
