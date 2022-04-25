package com.example.emt_lab2.model.dto;

import com.example.emt_lab2.model.Category;
import lombok.Data;
import lombok.Getter;

@Data
public class BooksDto {

    private String name;
    private Long authorId;
    private Category category;
    private Integer availableCopies;


}