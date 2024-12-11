package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.service.MovieService;
import com.epam.training.ticketservice.core.movie.service.MovieServiceImplementation;
import com.epam.training.ticketservice.core.user.model.User;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.service.UserService;
import com.epam.training.ticketservice.core.user.service.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class MovieCommands {

    private final MovieServiceImplementation movieServiceImplementation;
    private final UserService userService;

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "create movie", value = "Usage: <movieName> <movieCategory> <movieLength>")
    protected MovieDto createMovie(String movieName, String movieCategory, int movieLength ) {
        MovieDto movie = new MovieDto(movieName, movieCategory, movieLength);
        movieServiceImplementation.createMovie(movie);
        return movie;
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "update movie", value = "Usage: <movieName> <movieCategory> <movieLength>")
    protected MovieDto updateMovie(String movieName, String movieCategory, int movieLength ) {
        MovieDto movie = new MovieDto(movieName, movieCategory, movieLength);
        movieServiceImplementation.updateMovie(movie);
        return movie;
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "delete movie", value = "Usage: <movieName>")
    protected void deleteMovie(String movieName) {
        movieServiceImplementation.deleteMovie(movieName);
    }

    @ShellMethod(key = "list movies", value = "List all movies.")
    public String listMovies() {
        if (movieServiceImplementation.getAllMovies() == null) {
            return "There are no movies at the moment";
        };
        return movieServiceImplementation.getAllMovies().toString();

    }

   private Availability isAvailable(){
        Optional<UserDto> user = userService.describe();
        return user.isPresent() && user.get().role() == User.Role.ADMIN
                ? Availability.available()
                : Availability.unavailable("You are not an admin!");
    }

}
