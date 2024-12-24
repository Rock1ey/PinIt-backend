package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.model.Image;
import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.repository.ImageRepository;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author leye
 * @version 1.0
 * @description: 业务逻辑层，处理帖子的创建、查询等
 * @date 2024/12/23 21:59
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private OssService ossService; // 用于上传图片到 OSS

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts(String title) {
        return postRepository.findByTitleContaining(title);
    }

    public Post createPost(PostRequestDTO postRequest) throws IOException {
        // 创建 Post 实体
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        // post.setUser(new User(postRequest.getUserId())); // 设置 User
        postRepository.save(post);

        // 上传图片到 OSS 并保存图片 URL
        for (MultipartFile file : postRequest.getFiles()) {
            String objectName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            String imageUrl = ossService.uploadFile(file.getOriginalFilename(), objectName);

            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setPost(post); // 关联到 Post
            imageRepository.save(image);
        }

        return post;
    }

    public PostDTO getPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setImageUrls(post.getImages().stream()
                .map(Image::getImageUrl)
                .collect(Collectors.toList()));
        return postDTO;
    }

}
