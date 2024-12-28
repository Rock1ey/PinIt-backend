package org.leye.maven.pinitbackend.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 23:09
 */
@Getter
public class UserRegistrationDTO {
    private String username;
    private String password;
    // private String bio;
    // private MultipartFile avatar;
    // Getters and Setters
}
