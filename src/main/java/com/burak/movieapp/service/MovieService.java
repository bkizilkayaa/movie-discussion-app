package com.burak.movieapp.service;

import com.burak.movieapp.model.Movie;
import com.burak.movieapp.model.dto.MovieDTO;
import com.burak.movieapp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAllMovies(){
        List<Movie> movieList=movieRepository.findAll();
        return movieList.stream()
                .map(this::movieDTOBuilder)
                .collect(Collectors.toList());
    }
    public MovieDTO saveMovie(Movie movie){
        movieRepository.save(movie);
        return movieDTOBuilder(movie);
    }

    private MovieDTO movieDTOBuilder(Movie movie){
        return MovieDTO.builder()
                .Id(movie.getId())
                .commentList(movie.getCommentList())
                .movieName(movie.getName())
                .releaseYear(movie.getReleaseYear())
                .build();
    }

    public Movie findTheMovieByGivenId(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(()->new RuntimeException("movie not found"));
    }
}
