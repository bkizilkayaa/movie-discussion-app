package com.burak.movieapp.controller;

import com.burak.movieapp.model.Comment;
import com.burak.movieapp.model.dto.CommentDTO;
import com.burak.movieapp.model.dto.CommentSaveRequest;
import com.burak.movieapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(
            @RequestParam Optional<Long> userId,
            @RequestParam Optional<Long> movieId){
        return new ResponseEntity<>(commentService.getAllComments(userId,movieId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentSaveRequest comment){
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id){
        commentService.deleteComment(comment_id);
    }

}
