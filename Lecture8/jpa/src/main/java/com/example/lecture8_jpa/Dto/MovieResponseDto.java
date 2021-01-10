package com.example.lecture8_jpa.Dto;

import com.example.lecture8_jpa.Model.Movie;

import java.util.List;

public class MovieResponseDto {
    List<Movie> movies;

    public MovieResponseDto(List<Movie> movies) {
        this.movies = movies;
    }

}
