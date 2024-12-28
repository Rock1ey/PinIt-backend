package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.LoginRequestDTO;
import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRegistrationDTO;
import org.leye.maven.pinitbackend.dto.UserUpdateRequestDTO;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 19:24
 */
public interface UserService {
    public UserDTO registerUser(UserRegistrationDTO registrationDTO);
    public UserDTO findUserById(Long id);
    public UserDTO updateUser(UserUpdateRequestDTO userUpdateRequestD);
    public UserDTO userLogin(LoginRequestDTO loginRequest);
}
