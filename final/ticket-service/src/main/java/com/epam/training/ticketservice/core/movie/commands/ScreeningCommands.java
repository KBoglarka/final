package com.epam.training.ticketservice.core.movie.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDateTime;

@ShellComponent
@RequiredArgsConstructor
public class ScreeningCommands {

    @ShellMethod(key = "create screening", value = "Usage: <movieName> <roomName> <startTime>")
    public String createScreening(String movie, String room, LocalDateTime startTime){
        return "";
    }

    @ShellMethod(key = "delete screening", value = "Usage: <movieName> <roomName> <startTime>")
    public String deleteScreening(String movie, String room, LocalDateTime startTime){
        return "";
    }

    @ShellMethod(key = "list screenings", value = "List all screenings.")
    public String listScreenings(){
        return "";
    }
}
