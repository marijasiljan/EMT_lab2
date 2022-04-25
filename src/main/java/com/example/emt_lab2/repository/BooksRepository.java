package com.example.emt_lab2.repository;

import com.example.emt_lab2.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
