package com.burak.movieapp.controller;

import com.burak.movieapp.model.Comment;
import com.burak.movieapp.model.dto.CommentDTO;
import com.burak.movieapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.saveComment(comment), HttpStatus.CREATED);
    }

}
