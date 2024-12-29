package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import lombok.Setter;

// 展示用户数据的DTO
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String username;
    private String bio;
    private String avatar;
}
