package org.leye.maven.pinitbackend.dto;

import lombok.Getter;

// 用于登录传输数据
@Getter
public class LoginRequestDTO {
    private String username;
    private String password;
}

