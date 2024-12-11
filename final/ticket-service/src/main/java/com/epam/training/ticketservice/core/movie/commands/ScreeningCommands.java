package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.ScreeningDto;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import com.epam.training.ticketservice.core.movie.service.ScreeningServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
@RequiredArgsConstructor
public class ScreeningCommands {

    private final ScreeningServiceImplementation screeningServiceImplementation;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;

    @ShellMethod(key = "create screening", value = "Usage: <movieName> <roomName> <startTime>")
    public String createScreening(String movieName, String roomName, String startTime){
        var movie = movieRepository.findByMovieName(movieName).isPresent() ? movieRepository.findByMovieName(movieName).get() : null;
        var room = roomRepository.findByroomName(roomName).isPresent() ? roomRepository.findByroomName(roomName).get() : null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        if (movie == null || room == null){
            return "A film vagy terem nem létezik";
        }
        ScreeningDto screening = new ScreeningDto(movie, room, start);
        screeningServiceImplementation.createScreening(screening);
        return screening.toString();
    }

    @ShellMethod(key = "delete screening", value = "Usage: <movieName> <roomName> <startTime>")
    public String deleteScreening(String movieName, String roomName, String startTime){
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
}
