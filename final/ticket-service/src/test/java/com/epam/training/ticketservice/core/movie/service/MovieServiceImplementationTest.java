package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MovieServiceImplementationTest {

    private MovieServiceImplementation movieServiceImplementation;

    private static final Movie ENTITY = new Movie("How To Train Your Dragon", "animation", 98);
    private final MovieRepository movieRepository = mock(MovieRepository.class);
    private final MovieRepository movieRepository1 = mock(MovieRepository.class);
    private final MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);


    @Test
    void getAllMovies() {
        movieRepository1.save(ENTITY);
        Movie movie1 = new Movie("How To Train Your Dragon", "animation", 98);
        movieRepository.save(movie1);
        List<Movie> movies = movieRepository1.findAll();
        List<Movie> movies1 = movieRepository.findAll();

        Assertions.assertEquals(movies, movies1);
    }

    @Test
    void createMovie() {
        movieRepository1.save(ENTITY);
        underTest.createMovie("How To Train Your Dragon", "animation", 98);
        List<Movie> movies = movieRepository1.findAll();
        List<Movie> movies1 = movieRepository.findAll();
        Assertions.assertEquals(movies, movies1);
    }

    @Test
    void updateMovie() {
        movieRepository.save(ENTITY);
        underTest.updateMovie("How To Train Your Dragon", "animation", 100);
        Movie movie1 = new Movie("How To Train Your Dragon", "animation", 100);
        movieRepository1.save(movie1);
        List<Movie> movies = movieRepository1.findAll();
        List<Movie> movies1 = movieRepository.findAll();
        Assertions.assertEquals(movies, movies1);
    }

    @Test
    void deleteMovie() {
    }
}