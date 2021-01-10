package com.example.lecture8_jpa.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class ResponseDto<T> {

    T data;
    HttpStatus httpStatus;

    public ResponseDto(T data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
