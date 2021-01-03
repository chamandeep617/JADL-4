package com.example.demo.Repository;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbOperations {

    private Connection connection;

    private String tableName;

    public void getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","chaman@123");
        }
    }

    public void closeConnection(){
        if(connection != null){
            connection = null;
        }
    }


    public String createTable(String tableName) throws SQLException {

        getConnection();

        this.tableName = tableName;

        Statement statement = connection.createStatement();
        boolean isOpSucc = statement.execute("CREATE TABLE "+tableName+"(id INT primary key AUTO_INCREMENT,book_name VARCHAR(30),author_name VARCHAR(30),cost INT )");

        String str;

        if(isOpSucc){
            str = "Table "+tableName+" is created succesfully";
            System.out.println(str);
        }else {
            str = "Table " + tableName + " is not created succesfully";
            System.out.println(str);
        }

        closeConnection();
        return str;
    }


    public String insetBook(Book book) throws SQLException {
        getConnection();

        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO "+this.tableName+" VALUES (NULL, ?,?,?)");

        prepareStatement.setString(1,book.getName());
        prepareStatement.setString(2,book.getAuthorName());
        prepareStatement.setInt(3,book.getCost());

        int row = prepareStatement.executeUpdate();

        String str;
        if(row < 1){
            str = "Book is not inseted";
        }else{
            str = " Book is inserted successfully";
        }
        System.out.println(str);

        closeConnection();
        return str;
    }

    public List<Book> getAllBooks() throws SQLException {
        getConnection();

        List<Book> books = new ArrayList<>();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.tableName);

        while(resultSet.next()){

            // --- > some modification is required over here in order to get the id in the result
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = new Book(book_name,author_name,cost);
            books.add(book);
        }
        closeConnection();
        return books;
    }

    public Book getBookById(int id) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.tableName+" WHERE id = "+id);

        if(resultSet.next()){
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = new Book(book_name,author_name,cost);
            closeConnection();
            return book;
        }

        System.out.println("No book with the given id is present inside the DB");
        closeConnection();
        return null;
    }
}
