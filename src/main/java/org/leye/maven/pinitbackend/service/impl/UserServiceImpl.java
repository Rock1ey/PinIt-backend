package org.leye.maven.pinitbackend.service.impl;

import org.leye.maven.pinitbackend.dto.LoginRequestDTO;
import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRegistrationDTO;
import org.leye.maven.pinitbackend.dto.UserUpdateRequestDTO;
import org.leye.maven.pinitbackend.mapper.UserMapper;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.leye.maven.pinitbackend.service.OssService;
import org.leye.maven.pinitbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OssService ossService; // 用于上传头像到 OSS

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO registerUser(UserRegistrationDTO registrationDTO) {
        if (userRepository.findByUsername(registrationDTO.getUsername()) != null) {
            throw new RuntimeException("Username already taken");
        }

        // 创建新的用户并加密密码
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        userRepository.save(user);

        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserUpdateRequestDTO userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setBio(userUpdateRequest.getBio());
        user.setUsername(userUpdateRequest.getUsername());
        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO userLogin(LoginRequestDTO loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public String uploadAvatar(Long id, MultipartFile file) throws IOException {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        String newAvatar = ossService.uploadImage(file);
        user.setAvatar(newAvatar);
        userRepository.save(user); // 更新头像信息
        return newAvatar;
    }

}
