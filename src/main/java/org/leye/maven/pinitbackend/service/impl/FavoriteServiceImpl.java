package org.leye.maven.pinitbackend.service.impl;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.mapper.PostMapper;
import org.leye.maven.pinitbackend.model.Favorite;
import org.leye.maven.pinitbackend.model.Post;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.FavoriteRepository;
import org.leye.maven.pinitbackend.repository.PostRepository;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.leye.maven.pinitbackend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 22:05
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    // 添加收藏
    @Override
    public void addFavorite(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        // 创建新的收藏记录
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setPost(post);

        // 保存收藏记录
        favoriteRepository.save(favorite);
    }

    // 删除收藏
    @Override
    public void removeFavorite(Long userId, Long postId) {
        Favorite favorite = favoriteRepository.findByPostIdAndUserId(postId, userId);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        } else {
            throw new RuntimeException("Favorite not found");
        }
    }

    // 获取用户的所有收藏
    @Override
    public List<PostDTO> getUserFavorites(Long userId) {
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);
        List<Post> posts = favorites.stream().map(Favorite::getPost).toList();
        return posts.stream().map(post -> postMapper.toDTO(post)).collect(Collectors.toList());
    }

}
