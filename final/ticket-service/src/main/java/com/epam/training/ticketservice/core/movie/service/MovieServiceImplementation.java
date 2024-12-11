package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;


    @Override
    public List<MovieDto> getAllMovies() {
        if(movieRepository.count() == 0) {
            return null;
        }
        return movieRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .toList();
    }


    @Override
    public void createMovie(MovieDto movieDto) {
        Movie movie = new Movie(
                movieDto.getMovieName(),
                movieDto.getMovieCategory(),
                movieDto.getMovieLength()
        );
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        var updatedMovie = movieRepository.findByMovieName(movieDto.getMovieName());
        if (updatedMovie.isPresent()) {
            updatedMovie.get().setMovieCategory(movieDto.getMovieCategory());
            updatedMovie.get().setMovieLength(movieDto.getMovieLength());
            movieRepository.save(updatedMovie.get());
        }
    }

    @Override
    public void deleteMovie(String movieName) {
        var deletedMovie = movieRepository.findByMovieName(movieName);
        movieRepository.delete(deletedMovie.get());
    }

    private MovieDto mapEntityToDto(Movie movie) {
        return MovieDto.builder()
                .movieName(movie.getMovieName())
                .movieCategory(movie.getMovieCategory())
                .movieLength(movie.getMovieLength())
                .build();
    }


    private Optional<MovieDto> mapEntityToDto(Optional<Movie> movie){
        return movie.map(this::mapEntityToDto);
    }
}
