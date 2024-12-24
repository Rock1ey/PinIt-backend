package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.model.Image;
import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.repository.ImageRepository;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.leye.maven.pinitbackend.service.OssService;
import org.leye.maven.pinitbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author leye
 * @version 1.0
 * @description: 编写API控制器，给前端提供接口
 * @date 2024/12/23 21:59
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private OssService ossService;  // 使用 OSS 上传图片的服务

    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostRequestDTO postRequest) throws IOException {
        Post post = postService.createPost(postRequest);
        return ResponseEntity.ok(postService.getPostDTO(post));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Post>> getPosts(@RequestParam String title) {
        return ResponseEntity.ok(postService.getPosts(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return ResponseEntity.ok(postService.getPostDTO(post));
    }
}

