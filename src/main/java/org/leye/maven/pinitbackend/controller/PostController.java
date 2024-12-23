package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam String title) {
        return postService.getPosts(title);
    }
}

