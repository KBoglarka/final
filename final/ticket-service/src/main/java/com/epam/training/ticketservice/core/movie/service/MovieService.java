package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    void createMovie(String movieName, String movieCategory, int movieLength );
    void updateMovie(String movieName, String movieCategory, int movieLength);
    void deleteMovie(String movieName);
}
