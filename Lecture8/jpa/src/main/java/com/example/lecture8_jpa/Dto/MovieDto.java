package com.example.lecture8_jpa.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MovieDto {

    String nameOfMovie;
    String title;
    long Date;
    int ratings;
}
