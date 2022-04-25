package com.example.emt_lab2.web;

import com.example.emt_lab2.model.Books;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.model.dto.BooksDto;
import com.example.emt_lab2.service.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/book")
public class BooksController {

    private final BooksService bookService;

    public BooksController(BooksService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all/page/{page}/{size}")
    public List<Books> findAllWithPagination(@PathVariable Integer size, @PathVariable Integer page) {
        return bookService.findAllWithPagination(page,size).getContent();
    }

    @GetMapping("/all")
    public List<Books> findAll(){
        return bookService.findAll();
    }

    @PostMapping("/edit/{id}")
    public Books editBook(@PathVariable Long id, @RequestBody BooksDto dto){
        return bookService.edit(id, dto);
    }

    @PostMapping("/add")
    public Books addBook(@RequestBody BooksDto dto){
        return bookService.add(dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Books getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }
    @PostMapping("/take/{id}")
    public void takeBook(@PathVariable Long id){
        bookService.takeBook(id);
    }


}
