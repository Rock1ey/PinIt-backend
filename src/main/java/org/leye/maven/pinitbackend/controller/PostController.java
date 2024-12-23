package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.PostDTO;
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
    private ImageRepository imageRepository;

    @Autowired
    private OssService ossService;  // 使用 OSS 上传图片的服务

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @PostMapping("/upload")
    public String createPost(@RequestParam("title") String title,
                             @RequestParam("description") String description,
                             @RequestParam("userid") Long userid,
                             @RequestParam("files") MultipartFile[] files) throws IOException {

        // 创建 Post 实体
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setUserId(userid);
        postRepository.save(post);

        // 上传图片到 OSS 并保存图片 URL
        for (MultipartFile file : files) {
            // 生成上传文件名（可使用 UUID 或其他方式）
            String objectName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            String imageUrl = ossService.uploadFile(file.getOriginalFilename(), objectName);

            // 创建 Image 实体
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setPost(post);  // 将图片关联到帖子

            // 保存图片到数据库
            imageRepository.save(image);
        }

        return "Post created with images!";
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam String title) {
        return postService.getPosts(title);
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setUserid(post.getUserId());
        postDTO.setImageUrls(post.getImages().stream().map(Image::getImageUrl).collect(Collectors.toList()));
        return postDTO;
    }
}

