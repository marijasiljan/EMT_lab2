package com.example.emt_lab2.model;

import javax.persistence.*;

@Entity
public class Author {
    //За секој автор пак се
    //чуваат податоците: id (Long), name (String), surname (String), country (Country).

    @Id
    @GeneratedValue
    private Long Id;

    private String Name;

    private String Surname;

    @ManyToOne
    @Transient
    private Country country;



    public Author(String name, String surname, Country country) {
        Name = name;
        Surname = surname;
        this.country = country;
    }

    public Author() {

    }
}
