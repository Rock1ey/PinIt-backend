package org.leye.maven.pinitbackend.dto;

import lombok.Setter;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 10:01
 */
@Setter
public class UserDTO {
    private Long id;
    private String nickname;
    // private String password;
    private String bio;
    private String avatar;
}
