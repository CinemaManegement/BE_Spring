package com.example.be_spring.repository.movie;

import com.example.be_spring.dto.movie.MovieProjection;
import com.example.be_spring.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
    @Query("select  m.id as id, m.name as name, m.startDay as startDay, m.image as image from Movie as m")
    List<MovieProjection> findAllMovie();


}
