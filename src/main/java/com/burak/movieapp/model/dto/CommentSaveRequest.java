package com.burak.movieapp.model.dto;

import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class CommentSaveRequest {
    private String text;
    private Long movie_id;
    private Long user_id;
}
