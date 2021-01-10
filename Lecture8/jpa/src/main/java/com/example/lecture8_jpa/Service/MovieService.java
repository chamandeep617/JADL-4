package com.example.lecture8_jpa.Service;

import com.example.lecture8_jpa.Dto.MovieDto;
import com.example.lecture8_jpa.Model.Movie;
import com.example.lecture8_jpa.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String insertMovie(MovieDto movieDto) {

        Movie movieObj = new Movie(movieDto.getNameOfMovie(),movieDto.getTitle(),movieDto.getDate(),movieDto.getRatings());
        movieRepository.save(movieObj);
        return "Saved";
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
