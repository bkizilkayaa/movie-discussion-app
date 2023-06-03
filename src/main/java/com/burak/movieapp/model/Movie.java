package com.burak.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@RequiredArgsConstructor
public class Movie extends BaseModel {
    @Column
    private String name;

    @Column
    private String releaseYear;

    @OneToMany(mappedBy = "movie")
    private List<Comment> commentList;

}
