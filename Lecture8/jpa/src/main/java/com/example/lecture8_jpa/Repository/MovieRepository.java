package com.example.lecture8_jpa.Repository;

import com.example.lecture8_jpa.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

//    @Query()
    public List<Movie> findByNameOfMovieAndDate(String name, String date);

}
