package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository 来访问数据库，自带查询方法，也可自定义
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String title);
    List<Post> findByUserId(Long userId);

    @Query("SELECT p FROM Post p WHERE "
            + "(6371 * acos(cos(radians(:latitude)) * cos(radians(p.location.latitude)) * "
            + "cos(radians(p.location.longitude) - radians(:longitude)) + "
            + "sin(radians(:latitude)) * sin(radians(p.location.latitude)))) <= :range")
    List<Post> findPostsByLocationWithinRange(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("range") Double range);

}
