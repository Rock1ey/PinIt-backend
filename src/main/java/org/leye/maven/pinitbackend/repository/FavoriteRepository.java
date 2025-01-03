package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // 查找某个用户的所有收藏帖子
    List<Favorite> findByUserId(Long userId);

    // 查找某个帖子被哪些用户收藏
    List<Favorite> findByPostId(Long postId);

    Favorite findByPostIdAndUserId(Long postId, Long userId);
}

