package com.example.library_management.Exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id) {

        super("Book id not found : " + id);
    }
}