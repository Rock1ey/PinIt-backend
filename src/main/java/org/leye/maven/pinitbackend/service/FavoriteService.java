package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.model.Favorite;
import org.leye.maven.pinitbackend.model.Post;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/24 19:13
 */
public interface FavoriteService {
    public void addFavorite(Long userId, Long postId);
    public void removeFavorite(Long userId, Long postId);
    public List<Post> getUserFavorites(Long userId);
}
