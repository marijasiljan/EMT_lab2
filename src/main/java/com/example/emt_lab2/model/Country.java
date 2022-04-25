package com.example.emt_lab2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
    //За секоја земја се
    //чуваат податоците: id (Long), name (String), continent (String).

    @Id
    @GeneratedValue
    private Long Id;

    private String Name;

    private String Continent;


    public Country(String name, String continent) {
        Name = name;
        Continent = continent;
    }

    public Country() {

    }
}
