package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.PostDTO;

import java.util.List;

public interface FavoriteService {
    public void addFavorite(Long userId, Long postId);
    public void removeFavorite(Long userId, Long postId);
    public List<PostDTO> getUserFavorites(Long userId);
    public boolean checkFavorite(Long userId, Long postId);
}
