package com.example.library_management.Repository;

import com.example.library_management.Model.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks,Integer> {
}
