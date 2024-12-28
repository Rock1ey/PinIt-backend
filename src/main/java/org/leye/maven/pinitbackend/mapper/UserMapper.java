package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.model.User;
import org.springframework.stereotype.Component;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 23:18
 */
@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setBio(user.getBio());
        userDTO.setAvatar(user.getAvatar());
        return userDTO;
    }

}
