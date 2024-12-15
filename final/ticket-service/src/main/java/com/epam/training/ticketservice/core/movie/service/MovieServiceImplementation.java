package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        if(movieRepository.count() == 0) {
            return null;
        }
        return movieRepository.findAll()
                .stream()
                .toList();
    }


    @Override
    public void createMovie(String movieName, String movieCategory, int movieLength ) {
        movieRepository.save(new Movie(movieName, movieCategory, movieLength ));
    }

    @Override
    public void updateMovie(String movieName, String movieCategory, int movieLength) {
        var updatedMovie = movieRepository.findByMovieName(movieName);
        if (updatedMovie.isPresent()) {
            updatedMovie.get().setMovieCategory(movieCategory);
            updatedMovie.get().setMovieLength(movieLength);
            movieRepository.save(updatedMovie.get());
        }
    }

    @Override
    public void deleteMovie(String movieName) {
        var deletedMovie = movieRepository.findByMovieName(movieName);
        movieRepository.delete(deletedMovie.get());
    }
}
