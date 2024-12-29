package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.model.User;
import org.springframework.stereotype.Component;

// 将User实体类映射为DTO类
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
