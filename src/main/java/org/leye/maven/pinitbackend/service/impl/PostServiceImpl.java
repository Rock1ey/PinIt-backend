package org.leye.maven.pinitbackend.service.impl;

import org.leye.maven.pinitbackend.dto.PostCreateDTO;
import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.mapper.PostMapper;
import org.leye.maven.pinitbackend.model.Image;
import org.leye.maven.pinitbackend.model.Location;
import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.ImageRepository;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.leye.maven.pinitbackend.service.OssService;
import org.leye.maven.pinitbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Post 相关业务逻辑的实现
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OssService ossService; // 用于上传图片到 OSS

    @Override
    public String createPost(PostCreateDTO postRequest) throws IOException {
        User user = userRepository.findById(postRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // 创建 Post 实体
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setUser(user); // 设置 User
        post.setLocation(new Location(postRequest.getLatitude(), postRequest.getLongitude()));
        postRepository.save(post);

        MultipartFile[] files = postRequest.getImages();
        for (MultipartFile file : files) {
            String imageUrl = ossService.uploadImage(file);
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setPost(post);
            imageRepository.save(image);
        }

        return "create success";
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = postMapper.toDTO(post);
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return postMapper.toDTO(post);
        // return post;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updatePost(PostRequestDTO postRequest) {
        // 根据 ID 查找帖子
        Post post = postRepository.findById(postRequest.getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // 更新帖子的基本信息
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        // post.setLocation(new Location(postRequest.getLatitude(), postRequest.getLongitude()));

        // 删除旧图片， 如果有上传新的图片，则删除旧图片并保存新的
        if (postRequest.getFiles() != null && postRequest.getFiles().length > 0) {
            // 清除旧的图片，依据实际需求决定是否需要先删除
            for (Image image : post.getImages()) {
                imageRepository.delete(image);
                ossService.deleteFile(image.getImageUrl());
            }

//            // 上传新的图片并保存图片 URL
//            saveImages(postRequest, post);
        }

        // 更新帖子
        postRepository.save(post);  // 保存更新后的帖子
    }

    @Override
    public List<PostDTO> getPostsByUserId(Long userId){
        List<Post> posts = postRepository.findByUserId(userId);
        return posts.stream()
                .map(post -> postMapper.toDTO(post))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> searchPostsByTitle(String title) {
        List<Post> posts = postRepository.findByTitleContaining(title);
        return posts.stream()
                .map(post -> postMapper.toDTO(post))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> searchPostsByLocation(Double latitude, Double longitude, Double range) {
        List<Post> posts = postRepository.findPostsByLocationWithinRange(latitude, longitude, range);

        // 将 Post 实体转化为 PostDTO 并返回
        return posts.stream()
                .map(post -> postMapper.toDTO(post))
                .collect(Collectors.toList());
    }

}
