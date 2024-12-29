package org.leye.maven.pinitbackend.dto;

import lombok.Getter;

// 注册用户时传入的数据
@Getter
public class UserRegistrationDTO {
    private String username;
    private String password;
}
