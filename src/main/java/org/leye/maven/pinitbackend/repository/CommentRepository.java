package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 21:37
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostId(Long postId);
}
