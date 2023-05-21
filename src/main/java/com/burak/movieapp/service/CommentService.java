package com.burak.movieapp.service;

import com.burak.movieapp.model.Comment;
import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.dto.CommentDTO;
import com.burak.movieapp.model.dto.MovieDTO;
import com.burak.movieapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public List<CommentDTO> getAllComments(){
        List<Comment> commentList= commentRepository.findAll();
        return commentList.stream()
                .map(this::commentDtoBuild)
                .collect(Collectors.toList());
    }
    public CommentDTO saveComment(Comment comment){
        commentRepository.save(comment);
        return commentDtoBuild(comment);
    }
    private CommentDTO commentDtoBuild(Comment comment){
       return CommentDTO.builder()
                .text(comment.getText())
                .movie(comment.getMovie())
                .user(comment.getUser())
                .Id(comment.getId())
                .build();
    }
}
