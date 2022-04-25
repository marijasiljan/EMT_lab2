package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Books;
import com.example.emt_lab2.model.dto.BooksDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksService {

    List<Books> findAll();

    void delete(Long id);

    Books add(BooksDto dto);
    Books edit(Long id, BooksDto dto);
    void takeBook(Long id);
    Books getBook(Long id);

    Page<Books> findAllWithPagination(int page, int size);
}
