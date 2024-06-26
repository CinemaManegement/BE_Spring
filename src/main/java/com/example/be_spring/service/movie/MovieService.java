package com.example.be_spring.service.movie;

import com.example.be_spring.dto.movie.MovieProjection;
import com.example.be_spring.repository.movie.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService implements IMovieService{
    @Autowired
    private IMovieRepo iMovieRepo;
    @Override
    public List<MovieProjection> findAllMovie() {
        return iMovieRepo.findAllMovie();
    }


}
