package com.example.emt_lab2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Books {
   // id (Long), name (String),
    // category (enum), author (Author), availableCopies (Integer).

    @Id
    @GeneratedValue
    private Long Id;

    private String Name;

    private Integer availableCopies;

    @Enumerated
    private Category category;

    @ManyToOne
    private Author author;

    public Books(String name, Category category, Author author, Integer availableCopies) {
        Name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }

    public Books() {

    }
}
