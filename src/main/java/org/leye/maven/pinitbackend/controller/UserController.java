package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRequestDTO;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.leye.maven.pinitbackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author leye
 * @version 1.0
 * @description: 给前端提供用户有关接口
 * @date 2024/12/24 10:40
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> create(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userServiceImpl.createUser(userRequestDTO);
        return ResponseEntity.ok(userServiceImpl.getUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(userServiceImpl.getUser(user));
    }
}
