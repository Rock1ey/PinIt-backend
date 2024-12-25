package org.leye.maven.pinitbackend.controller;

import jakarta.persistence.PostUpdate;
import org.hibernate.annotations.DynamicUpdate;
import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.mapper.PostMapper;
import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.leye.maven.pinitbackend.service.PostService;
import org.leye.maven.pinitbackend.service.impl.OssServiceImpl;
import org.leye.maven.pinitbackend.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private PostMapper postMapper;

    @Autowired
    private OssServiceImpl ossServiceImpl;  // 使用 OSS 上传图片的服务

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostRequestDTO postRequest) throws IOException {
        PostDTO post = postService.createPost(postRequest);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id) {
        PostDTO post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/user/{userId}")
    public List<PostDTO> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) throws IOException {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDTO postRequest) throws IOException {
        postService.updatePost(postRequest);
    }

    @GetMapping("/search")
    public List<PostDTO> searchPostsByTitle(@Param("title") String title) {
        return postService.searchPostsByTitle(title);
    }

    @GetMapping("/searchByLocation")
    public List<PostDTO> searchPostsByLocation(
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude,
            @RequestParam("range") Double range) {
        return postService.searchPostsByLocation(latitude, longitude, range);
    }
}

