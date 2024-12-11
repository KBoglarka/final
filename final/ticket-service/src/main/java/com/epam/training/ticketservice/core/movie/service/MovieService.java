package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    void createMovie(MovieDto movieDto);
    void updateMovie(MovieDto movieDto);
    void deleteMovie(String movieName);
}
