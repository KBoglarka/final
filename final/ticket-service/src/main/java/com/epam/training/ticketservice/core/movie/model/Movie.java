package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private String movieCategory;
    private int movieLength;

    public Movie(String movieName, String movieCategory, int movieLength) {
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.movieLength = movieLength;
    }

    public Movie() {

    }


    @Override
    public String toString() {
        return movieName + " (" + movieCategory + ", " + movieLength + " minutes)";
    }

}
