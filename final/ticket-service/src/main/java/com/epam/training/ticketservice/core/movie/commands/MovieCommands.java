package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.service.MovieService;
import com.epam.training.ticketservice.core.movie.service.MovieServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class MovieCommands {

    private final MovieServiceImplementation movieServiceImplementation;
    private final MovieRepository movieRepository;
    private final DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

    @ShellMethod(key = "create movie", value = "Usage: <movieName> <movieCategory> <movieLength>")
    public MovieDto createMovie(String movieName, String movieCategory, int movieLength ) {
        MovieDto movie = new MovieDto(movieName, movieCategory, movieLength);
        movieServiceImplementation.createMovie(movie);
        return movie;
    }

    @ShellMethod(key = "update movie", value = "Usage: <movieName> <movieCategory> <movieLength>")
    public MovieDto updateMovie(String movieName, String movieCategory, int movieLength ) {
        MovieDto movie = new MovieDto(movieName, movieCategory, movieLength);
        movieServiceImplementation.updateMovie(movie);
        return movie;
    }

    @ShellMethod(key = "delete movie", value = "Usage: <movieName>")
    public void deleteMovie(String movieName) {
        movieServiceImplementation.deleteMovie(movieName);
    }

    @ShellMethod(key = "list movies", value = "List all movies.")
    public String listMovies() {
        if (movieServiceImplementation.getAllMovies() == null) {
            return "There are no movies at the moment";
        };
        return movieServiceImplementation.getAllMovies().toString();

    }
}
