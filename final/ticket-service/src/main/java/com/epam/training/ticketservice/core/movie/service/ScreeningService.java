package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.model.dto.ScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {

    List<Screening> getAllScreenings();
    void createScreening(Movie movie, Room room, LocalDateTime start);
    void deleteScreening(Movie movie, Room room, LocalDateTime start);
}
