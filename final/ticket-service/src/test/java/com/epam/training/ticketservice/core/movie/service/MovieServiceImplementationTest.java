package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class MovieServiceImplementationTest {

    private static final Movie ENTITY = new Movie("How To Train Your Dragon", "animation", 98);

    @Autowired
    private MovieRepository movieRepository = mock(MovieRepository.class);

    //private final MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);


    @Test
    void getAllMovies() {
        MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);
        underTest.createMovie("How To Train Your Dragon", "animation", 98);
        List<Movie> actualmovies = underTest.getAllMovies();
        List<Movie> expectedmovies = movieRepository.findAll();
        assertEquals(expectedmovies, actualmovies);
    }

    @Test
    void getAllMoviesNull() {
        MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);
        assertEquals(underTest.getAllMovies(), null);
    }

    @Test
    void createMovie() {
        MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);
        underTest.createMovie("How To Train Your Dragon", "animation", 98);
        assertEquals(underTest.getAllMovies().size(), 1);
    }

    @Test
    void updateMovie() {
        MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);
        underTest.createMovie("How To Train Your Dragon", "animation", 98);
        underTest.updateMovie("How To Train Your Dragon", "animation", 100);
        underTest.updateMovie("How To Train Your Dragon 2", "animation", 100);
        assertEquals(underTest.getAllMovies().size(), 1);
    }

    @Test
    void deleteMovie() {
        MovieServiceImplementation underTest = new MovieServiceImplementation(movieRepository);
        underTest.createMovie("How To Train Your Dragon", "animation", 98);
        underTest.deleteMovie("How To Train Your Dragon");
        assertEquals(underTest.getAllMovies(), null);
    }
}