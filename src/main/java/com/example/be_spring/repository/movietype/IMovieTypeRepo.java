package com.example.be_spring.repository.movietype;

import com.example.be_spring.model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieTypeRepo extends JpaRepository<MovieType, Integer> {
}
