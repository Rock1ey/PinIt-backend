package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 10:01
 */
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String username;
    // private String password;
    private String bio;
    private String avatar;
}
