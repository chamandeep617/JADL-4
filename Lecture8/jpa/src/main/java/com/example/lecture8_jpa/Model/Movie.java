package com.example.lecture8_jpa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name = "films")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;

    @Column(name = "name")
    String nameOfMovie;
    String title;
    long Date;
    int ratings;

    public Movie(String nameOfMovie, String title, long date, int ratings) {
        this.nameOfMovie = nameOfMovie;
        this.title = title;
        Date = date;
        this.ratings = ratings;
    }

    public Movie() {

    }
}
