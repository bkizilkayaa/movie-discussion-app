package com.burak.movieapp.service;

import com.burak.movieapp.exception.CommentNotFoundException;
import com.burak.movieapp.model.Comment;
import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.dto.CommentDTO;
import com.burak.movieapp.model.dto.CommentSaveRequest;
import com.burak.movieapp.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MovieService movieService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, MovieService movieService, UserService userService) {
        this.commentRepository = commentRepository;
        this.movieService = movieService;
        this.userService=userService;
    }

     public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> movieId){
        if(userId.isPresent()&&movieId.isPresent()){
            return commentRepository.findByUserIdAndMovieId(userId.get(),movieId.get());
        }
        else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }
        else if(movieId.isPresent()){
            return commentRepository.findByMovieId(movieId.get());
        }
        return commentRepository.findAll();
    }
    public CommentDTO saveComment(CommentSaveRequest comment){
        Comment cmtToSave= new Comment();
        cmtToSave.setText(comment.getText());
        cmtToSave.setMovie(movieService.findTheMovieByGivenId(comment.getMovie_id()));
        cmtToSave.setUser(userService.findUserByGivenId(comment.getUser_id()));
        commentRepository.save(cmtToSave);
        return commentDtoBuild(cmtToSave);
    }
    private CommentDTO commentDtoBuild(Comment comment){
       return CommentDTO.builder()
                .text(comment.getText())
                .movie(comment.getMovie())
                .user(comment.getUser())
                .Id(comment.getId())
                .build();
    }

    public void deleteComment(Long commentId) {
        if(findCommentInstanceOrElseThrowException(commentId)!=null)
            commentRepository.deleteById(commentId);

    }

    private Comment findCommentInstanceOrElseThrowException(Long commentId){
        return commentRepository.findById(commentId)
                .orElseThrow(()->new CommentNotFoundException("comment not found by given id : "+commentId));
    }

    public CommentDTO findCommentByGivenIdAndReturnDTO(Long commentId){
         Comment instance= findCommentInstanceOrElseThrowException(commentId); //gets instance
         return commentDtoBuild(instance); //build an object which is transferring-object
    }
    @Transactional
    public void addCommentToGivenMovie(String text, Long movie_id){
        Movie movie= movieService.findTheMovieByGivenId(movie_id);

    }
}
