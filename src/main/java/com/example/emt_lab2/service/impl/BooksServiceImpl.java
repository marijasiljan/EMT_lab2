package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Books;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.model.dto.BooksDto;
import com.example.emt_lab2.model.exceptions.AuthorNotFoundException;
import com.example.emt_lab2.model.exceptions.BookNotFoundException;
import com.example.emt_lab2.repository.AuthorRepository;
import com.example.emt_lab2.repository.BooksRepository;
import com.example.emt_lab2.service.BooksService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;


    public BooksServiceImpl(BooksRepository booksRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Books> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Books book = this.booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
        this.booksRepository.delete(book);
    }

    @Override
    public Books add(BooksDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(AuthorNotFoundException::new);
        Books book = new Books(dto.getName(), dto.getCategory(), author, dto.getAvailableCopies());
        this.booksRepository.save(book);
        return book;
    }

    @Override
    public Books edit(Long id, BooksDto dto) {
        Books book = this.getBook(id);
        book.setName(dto.getName());
        book.setCategory(Category.valueOf(String.valueOf(dto.getCategory())));

        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(AuthorNotFoundException::new);

        book.setAuthor(author);
        book.setAvailableCopies(dto.getAvailableCopies());
        booksRepository.save(book);

        return book;
    }

    @Override
    public void takeBook(Long id) {
        Books book = this.getBook(id);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        booksRepository.save(book);
    }

    @Override
    public Books getBook(Long id) {
        return booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Page<Books> findAllWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return booksRepository.findAll(pageable);
    }
}
