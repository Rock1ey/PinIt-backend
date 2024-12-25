package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.dto.PostRequestDTO;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 19:12
 */
public interface PostService {
    public PostDTO createPost(PostRequestDTO postRequestDTO);
    public List<PostDTO> getAllPosts();
    public PostDTO getPostById(Long id);
    public void deletePost(Long id);
    public void updatePost(PostRequestDTO postRequestDTO);
    public List<PostDTO> getPostsByUserId(Long userId);
    public List<PostDTO> searchPostsByTitle(String title);
    public List<PostDTO> searchPostsByLocation(Double latitude, Double longitude, Double range);
}
