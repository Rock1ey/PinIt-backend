package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.PostCreateDTO;
import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

//    @PostMapping
//    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateDTO postRequest) throws IOException {
//        PostDTO post = postService.createPost(postRequest);
//        return ResponseEntity.ok(post);
//    }

    // 创建新帖子并上传
    @PostMapping
    public ResponseEntity<String> createPost(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("userId") Long userId,
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude,
            @RequestParam("images") MultipartFile[] images) throws IOException {

        PostCreateDTO postRequest = new PostCreateDTO();
        postRequest.setTitle(title);
        postRequest.setDescription(description);
        postRequest.setUserId(userId);
        postRequest.setLatitude(latitude);
        postRequest.setLongitude(longitude);
        postRequest.setImages(images);

        // PostDTO post = postService.createPost(postRequest);
        return ResponseEntity.ok(postService.createPost(postRequest));
    }

    // 获取所有帖子
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id) {
        PostDTO post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // 获取某个用户的所有帖子
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

    // 根据标题搜索
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

