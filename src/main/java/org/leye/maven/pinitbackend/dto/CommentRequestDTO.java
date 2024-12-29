package org.leye.maven.pinitbackend.dto;

import lombok.Getter;

@Getter
public class CommentRequestDTO {
    private Long id;
    private String text;
    private int score;
    private Long userId;
}
