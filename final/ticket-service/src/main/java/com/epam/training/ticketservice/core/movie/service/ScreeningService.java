package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;

import java.time.LocalDateTime;

public interface ScreeningService {

    void createScreening(Movie movie, Room room, LocalDateTime startTime);
    void deleteScreening(Movie movie, Room room, LocalDateTime startTime);
}
