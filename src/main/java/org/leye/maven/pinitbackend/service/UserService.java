package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRequestDTO;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 19:24
 */
public interface UserService {
    public UserDTO createUser(UserRequestDTO userRequestDTO);
    public UserDTO findUserById(Long id);
    public UserDTO updateUser(UserRequestDTO userRequestDTO);
    public UserDTO userLogin(UserRequestDTO userRequestDTO);
}
