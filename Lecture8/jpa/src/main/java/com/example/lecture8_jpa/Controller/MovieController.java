package com.example.lecture8_jpa.Controller;

import com.example.lecture8_jpa.Dto.MovieDto;
import com.example.lecture8_jpa.Dto.MovieResponseDto;
import com.example.lecture8_jpa.Dto.ResponseDto;
import com.example.lecture8_jpa.Model.Movie;
import com.example.lecture8_jpa.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/insertMovie")
    public ResponseDto<String> insertMovie(@RequestBody MovieDto movieDto){


        String res = movieService.insertMovie(movieDto);
        return new ResponseDto<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
   public ResponseDto<List<MovieResponseDto>> getMovies(){
        List<Movie> movieList = movieService.getMovies();
        return new ResponseDto<>((List<MovieResponseDto>) new MovieResponseDto(movieList),HttpStatus.OK);
    }





}
