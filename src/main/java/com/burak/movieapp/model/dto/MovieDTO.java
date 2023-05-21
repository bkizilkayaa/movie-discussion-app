package com.burak.movieapp.model.dto;

import com.burak.movieapp.model.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class MovieDTO {
    private Long Id;
    private String releaseYear;
    private List<Comment> commentList;
}
