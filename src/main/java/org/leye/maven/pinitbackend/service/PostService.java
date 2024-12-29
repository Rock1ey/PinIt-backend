package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.PostCreateDTO;
import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;
import org.leye.maven.pinitbackend.model.Post;

import java.io.IOException;
import java.util.List;

// 定义Post相关业务逻辑
public interface PostService {
    public String createPost(PostCreateDTO postCreateDTO) throws IOException;
    public List<PostDTO> getAllPosts();
    public PostDTO getPostById(Long id);
    public void deletePost(Long id);
    public void updatePost(PostRequestDTO postRequestDTO);
    public List<PostDTO> getPostsByUserId(Long userId);
    public List<PostDTO> searchPostsByTitle(String title);
    public List<PostDTO> searchPostsByLocation(Double latitude, Double longitude, Double range);
}
