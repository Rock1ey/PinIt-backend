package org.leye.maven.pinitbackend.service.impl;

import org.leye.maven.pinitbackend.dto.CommentDTO;
import org.leye.maven.pinitbackend.dto.CommentRequestDTO;
import org.leye.maven.pinitbackend.mapper.CommentMapper;
import org.leye.maven.pinitbackend.model.Comment;
import org.leye.maven.pinitbackend.model.User;
import org.leye.maven.pinitbackend.repository.CommentRepository;
import org.leye.maven.pinitbackend.repository.UserRepository;
import org.leye.maven.pinitbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 21:36
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public CommentDTO saveComment(CommentRequestDTO commentRequest){
        User user = userRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // 创建 Comment 实体
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setText(commentRequest.getText());
        comment.setScore(commentRequest.getScore());
        commentRepository.save(comment);
        return commentMapper.toCommentDTO(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDTO> getComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment -> commentMapper.toCommentDTO(comment))
                .collect(Collectors.toList());
    }

}
