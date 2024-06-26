package com.example.be_spring.controller;

import com.example.be_spring.dto.movie.MovieProjection;
import com.example.be_spring.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<MovieProjection>> findAllMovie() {
        List<MovieProjection> list = movieService.findAllMovie();
        return ResponseEntity.ok(list);
    }


}
