package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 10:03
 */
@Getter
public class UserUpdateRequestDTO {
    private Long id;
    private String username;
    // private String password;
    private String bio;
    private MultipartFile avatar;
}
