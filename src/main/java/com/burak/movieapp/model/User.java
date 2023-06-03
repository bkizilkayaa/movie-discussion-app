package com.burak.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@RequiredArgsConstructor
public class User extends BaseModel {
    //users has id primary key which is Long data type
    //and have creation Time
    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
}
