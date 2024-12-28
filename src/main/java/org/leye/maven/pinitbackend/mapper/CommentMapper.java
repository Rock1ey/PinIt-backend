package org.leye.maven.pinitbackend.mapper;

import org.leye.maven.pinitbackend.dto.CommentDTO;
import org.leye.maven.pinitbackend.model.Comment;
import org.springframework.stereotype.Component;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/26 21:31
 */
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
