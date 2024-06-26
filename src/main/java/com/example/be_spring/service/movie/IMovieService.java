package com.example.be_spring.service.movie;

import com.example.be_spring.dto.movie.MovieProjection;

import java.util.List;

public interface IMovieService {
    List<MovieProjection> findAllMovie();

}
