package com.burak.movieapp.controller;

import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.dto.MovieDTO;
import com.burak.movieapp.repository.MovieRepository;
import com.burak.movieapp.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.saveMovie(movie),HttpStatus.CREATED);
    }
}
