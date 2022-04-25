package com.example.emt_lab2.config;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Books;
import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.repository.AuthorRepository;
import com.example.emt_lab2.repository.BooksRepository;
import com.example.emt_lab2.repository.CountryRepository;
import com.example.emt_lab2.service.AuthorService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.example.emt_lab2.model.Category.*;

@Component
@Getter
public class DataHolder {

    public static List<Books> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();
    public final BooksRepository booksRepository;
    public final CountryRepository countryRepository;
    public final AuthorRepository authorRepository;
    public final AuthorService authorService;

    public DataHolder(BooksRepository booksRepository, CountryRepository countryRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.booksRepository = booksRepository;
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country("North Macedonia", "Europe");
        Country country2 = new Country("Greece", "Europe");
        Country country3 = new Country("Netherlands", "Europe");
        Country country4 = new Country("Utah", "USA");
        Country country5 = new Country("Florida", "USA");

        Author author1 = new Author("William", "Shakespeare", country1);
        Author author2 = new Author("Agatha", "Christie", country2);
        Author author3 = new Author("Barbara", "Cartland", country3);
        Author author4 = new Author("Danielle", "Steel", country4);
        Author author5 = new Author("Harold", "Robbins", country5);

        Books book1 = new Books("Romeo and Juliet", DRAMA, author1, 10);
        Books book2 = new Books("Miss Marple", FANTASY, author2, 5);
        Books book3 = new Books("Book3", CLASSICS, author3, 10);
        Books book4 = new Books("Book4", FANTASY, author4, 20);
        Books book5 = new Books("Book5", CLASSICS, author5, 50);
        Books book6 = new Books("Book6", CLASSICS, author4, 10);
        Books book7 = new Books("Book7", FANTASY, author5, 20);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);

        countryRepository.saveAll(countries);
        authorRepository.saveAll(authors);
        booksRepository.saveAll(books);

    }

}
