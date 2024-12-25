package org.leye.maven.pinitbackend.service.impl;

import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRequestDTO;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author leye
 * @version 1.0
 * @description: 业务逻辑层，处理用户登录、注册等
 * @date 2024/12/24 10:04
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OssServiceImpl ossServiceImpl; // 用于上传头像到 OSS

    public User createUser(UserRequestDTO userRequest) {
        User user = new User();
        user.setNickname(userRequest.getNickname());
        user.setPassword(userRequest.getPassword());
        user.setBio(userRequest.getBio());

        MultipartFile avatar = userRequest.getAvatar();
        String objectName = UUID.randomUUID().toString() + "-" + avatar.getOriginalFilename();
        String avatarUrl = ossServiceImpl.uploadFile(avatar.getOriginalFilename(), objectName);

        user.setAvatar(avatarUrl);
        return userRepository.save(user);
    }

    public UserDTO getUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNickname(user.getNickname());
        userDTO.setBio(user.getBio());
        userDTO.setAvatar(user.getAvatar());
        return userDTO;
    }
}
