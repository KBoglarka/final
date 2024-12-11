package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.ScreeningDto;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import com.epam.training.ticketservice.core.movie.repository.ScreeningRepository;
import com.epam.training.ticketservice.core.movie.service.ScreeningServiceImplementation;
import com.epam.training.ticketservice.core.user.model.User;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class ScreeningCommands {

    private final ScreeningServiceImplementation screeningServiceImplementation;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;
    private final UserService userService;
    private final ScreeningRepository screeningRepository;

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "create screening", value = "Usage: <movieName> <roomName> <startTime>")
    protected String createScreening(String movieName, String roomName, String startTime){
        var movie = movieRepository.findByMovieName(movieName).isPresent() ? movieRepository.findByMovieName(movieName).get() : null;
        var room = roomRepository.findByroomName(roomName).isPresent() ? roomRepository.findByroomName(roomName).get() : null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        if (movie == null || room == null){
            return "A film vagy terem nem létezik";
        }

        if (screeningRepository.findScreeningByRoom(room).stream().findAny().isPresent()){
            List<Screening> sameroomscreening = screeningRepository.findScreeningByRoom(room);
            for (Screening screening : sameroomscreening){
                if (screening.getStartTime().isBefore(start) && screening.getStartTime().plusMinutes(screening.getMovie().getMovieLength()).isAfter(start)){
                    return "There is an overlapping screening";
                } else if (screening.getStartTime().isBefore(start) && screening.getStartTime().plusMinutes(screening.getMovie().getMovieLength()+10).isAfter(start)) {
                    return "This would start in the break period after another screening in this room";
                }
            }
        };

        ScreeningDto screening = new ScreeningDto(movie, room, start);
        screeningServiceImplementation.createScreening(screening);
        return screening.toString();
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "delete screening", value = "Usage: <movieName> <roomName> <startTime>")
    protected String deleteScreening(String movieName, String roomName, String startTime){
        var movie = movieRepository.findByMovieName(movieName).isPresent() ? movieRepository.findByMovieName(movieName).get() : null;
        var room = roomRepository.findByroomName(roomName).isPresent() ? roomRepository.findByroomName(roomName).get() : null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        if (movie == null || room == null){
            return "A film vagy terem nem létezik";
        }
        ScreeningDto screening = new ScreeningDto(movie, room, start);
        screeningServiceImplementation.deleteScreening(screening);
        return "Vetítés törölve!";
    }

    @ShellMethod(key = "list screenings", value = "List all screenings.")
    public String listScreenings(){
        if (screeningServiceImplementation.getAllScreenings() == null) {
            return "There are no screenings at the moment";
        };
        return screeningServiceImplementation.getAllScreenings().toString();
    }

    private Availability isAvailable(){
        Optional<UserDto> user = userService.describe();
        return user.isPresent() && user.get().role() == User.Role.ADMIN
                ? Availability.available()
                : Availability.unavailable("You are not an admin!");
    }
}
