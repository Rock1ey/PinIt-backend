package org.leye.maven.pinitbackend.dto;

import lombok.Getter;

// 用户更新的数据传入
@Getter
public class UserUpdateRequestDTO {
    private Long id;
    private String username;
    private String bio;
}
