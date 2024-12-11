package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.ScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {

    List<ScreeningDto> getAllScreenings();
    void createScreening(ScreeningDto screeningDto);
    void deleteScreening(ScreeningDto screeningDto);
}
