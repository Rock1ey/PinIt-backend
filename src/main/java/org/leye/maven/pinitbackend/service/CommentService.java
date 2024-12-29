package org.leye.maven.pinitbackend.service;

import org.leye.maven.pinitbackend.dto.CommentDTO;
import org.leye.maven.pinitbackend.dto.CommentRequestDTO;

import java.util.List;

public interface CommentService {
    public CommentDTO saveComment(CommentRequestDTO commentRequest);
    public void deleteComment(Long id);
    public List<CommentDTO> getComments(Long postId);
}
