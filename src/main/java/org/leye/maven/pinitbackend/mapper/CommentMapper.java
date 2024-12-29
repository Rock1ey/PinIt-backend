package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.CommentDTO;
import org.leye.maven.pinitbackend.model.Comment;
import org.springframework.stereotype.Component;

// 将Comment实体类映射为DTO类
@Component
public class CommentMapper {

    public CommentDTO toCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setText(comment.getText());
        commentDTO.setScore(comment.getScore());
        commentDTO.setAvatar(comment.getUser().getAvatar());
        commentDTO.setUsername(comment.getUser().getUsername());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        return commentDTO;
    }

}
