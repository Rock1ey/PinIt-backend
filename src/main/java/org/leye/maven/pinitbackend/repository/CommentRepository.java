package org.leye.maven.pinitbackend.repository;

import org.leye.maven.pinitbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostId(Long postId);
}
