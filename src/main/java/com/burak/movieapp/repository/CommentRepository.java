package com.burak.movieapp.repository;

import com.burak.movieapp.model.Comment;
import com.burak.movieapp.model.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUserId(Long userId);

    List<Comment> findByMovieId(Long movieId);
    List<Comment> findByUserIdAndMovieId(Long userId, Long movieId);
}
