package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MOVIE")
@NoArgsConstructor
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


    @Override
    public String toString() {
        return movieName + " (" + movieCategory + ", " + movieLength + " minutes)";
    }

}
