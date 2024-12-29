package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.LoginRequestDTO;
import org.leye.maven.pinitbackend.dto.UserDTO;
import org.leye.maven.pinitbackend.dto.UserRegistrationDTO;
import org.leye.maven.pinitbackend.dto.UserUpdateRequestDTO;
import org.leye.maven.pinitbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    // 创建新账号
    @PostMapping("/register")
    public ResponseEntity<UserDTO> create(@RequestBody UserRegistrationDTO userRegistration) {
        try {
            UserDTO user = userService.registerUser(userRegistration);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        try {
            UserDTO user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDTO userUpdateRequest) {
        try {
            UserDTO user = userService.updateUser(userUpdateRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 用户登录
    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody LoginRequestDTO loginRequest) {
        try {
            UserDTO user = userService.userLogin(loginRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 上传头像
    @PostMapping("/upload-avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("id") Long id, @RequestParam("avatar") MultipartFile file) throws IOException {
        String avatar = userService.uploadAvatar(id,file);
        return ResponseEntity.ok(avatar);
    }

}
