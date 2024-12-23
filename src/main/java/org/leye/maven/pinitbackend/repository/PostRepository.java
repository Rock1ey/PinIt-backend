package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author leye
 * @description: 使用 JpaRepository 来访问数据库
 * @date 2024/12/23 21:57
 * @version 1.0
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String title);
}
