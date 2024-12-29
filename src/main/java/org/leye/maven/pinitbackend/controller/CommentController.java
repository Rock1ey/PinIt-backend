package org.leye.maven.pinitbackend.controller;

import org.leye.maven.pinitbackend.dto.CommentDTO;
import org.leye.maven.pinitbackend.dto.CommentRequestDTO;
import org.leye.maven.pinitbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> save(@RequestBody CommentRequestDTO commentRequest) {
        CommentDTO comment = commentService.saveComment(commentRequest);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CommentDTO>> getComments(@Param("postId") Long postId) {
        List<CommentDTO> comments = commentService.getComments(postId);
        return ResponseEntity.ok(comments);
    }

}
