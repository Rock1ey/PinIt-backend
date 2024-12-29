package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.PostDTO;
import org.leye.maven.pinitbackend.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 用户收藏帖子
    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestParam Long userId, @RequestParam Long postId) {
        favoriteService.addFavorite(userId, postId);
        return ResponseEntity.ok("Post added to favorites");
    }

    // 用户取消收藏帖子
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFavorite(@RequestParam Long userId, @RequestParam Long postId) {
        favoriteService.removeFavorite(userId, postId);
        return ResponseEntity.ok("Post removed from favorites");
    }

    // 获取用户收藏的所有帖子
    @GetMapping("/user/{userId}")
    public List<PostDTO> getUserFavorites(@PathVariable Long userId) {
        return favoriteService.getUserFavorites(userId);
    }

    // 判断用户是否收藏帖子
    @PostMapping("/check")
    public boolean checkFavorite(@RequestParam Long userId, @RequestParam Long postId) {
        return favoriteService.checkFavorite(userId,postId);
    }

}

