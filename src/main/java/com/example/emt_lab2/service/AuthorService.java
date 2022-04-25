package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author saveAuthor(Author author);
}
