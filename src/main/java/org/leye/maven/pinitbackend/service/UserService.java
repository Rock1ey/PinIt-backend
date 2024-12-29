package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.LoginRequestDTO;
import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRegistrationDTO;
import org.leye.maven.pinitbackend.dto.UserUpdateRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    public UserDTO registerUser(UserRegistrationDTO registrationDTO);
    public UserDTO findUserById(Long id);
    public UserDTO updateUser(UserUpdateRequestDTO userUpdateRequestD);
    public UserDTO userLogin(LoginRequestDTO loginRequest);
    public String uploadAvatar(Long id, MultipartFile file) throws IOException;
}
