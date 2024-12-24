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
public class UserRequestDTO {
    private String nickname;
    private String password;
    private String bio;
    private MultipartFile avatar;
}
