package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.DbOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    DbOperations dbOperations;

    public String createTable(String tableName) throws SQLException {
        return dbOperations.createTable(tableName);
    }

    public String insetBook(Book book) throws SQLException {
        return dbOperations.insetBook(book);
    }

    public List<Book> getAllBooks() throws SQLException {
        return dbOperations.getAllBooks();
    }

    public Book getBookById(int id) throws SQLException {
        return dbOperations.getBookById(id);
    }
}
