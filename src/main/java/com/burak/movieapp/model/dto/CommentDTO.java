package com.burak.movieapp.model.dto;

import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CommentDTO {
    private Long Id;
    private String text;
    private Movie movie;
    private User user;

}
