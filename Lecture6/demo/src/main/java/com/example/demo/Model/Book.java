package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
//@ToString
public class Book {

    private int id;
    private String name;
    private String authorName;
    private int cost;

    public Book(String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    @Override
    public String toString() {
    }
}
