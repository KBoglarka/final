package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.repository.ScreeningRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ScreeningServiceImplementationTest {

    private final static Screening ENTITY = new Screening(
            new Movie("How To Train Your Dragon", "animation", 98),
            new Room("A25", 10, 10),
            LocalDateTime.of(2024, 12, 10, 8,12));
    private final ScreeningRepository screeningRepository = mock(ScreeningRepository.class);
    private final ScreeningRepository screeningRepository1 = mock(ScreeningRepository.class);
    private final ScreeningServiceImplementation underTest = new ScreeningServiceImplementation(screeningRepository);

    @Test
    void getAllScreenings() {
        screeningRepository1.save(ENTITY);
        Screening screening1 = new Screening(new Movie("How To Train Your Dragon", "animation", 98), new Room("A25", 10, 10), LocalDateTime.of(2024, 12, 10, 8,12));
        screeningRepository.save(screening1);
        List<Screening> screenings = screeningRepository1.findAll();
        List<Screening> screenings1 = screeningRepository.findAll();

        Assertions.assertEquals(screenings, screenings1);
    }

    @Test
    void createScreening() {
        screeningRepository1.save(ENTITY);
        underTest.createScreening(
                new Movie("How To Train Your Dragon", "animation", 98),
                new Room("A25", 10, 10),
                LocalDateTime.of(2024, 12, 10, 8,12));
        List<Screening> screenings = screeningRepository1.findAll();
        List<Screening> screenings1 = screeningRepository.findAll();
        Assertions.assertEquals(screenings, screenings1);
    }

    @Test
    void deleteScreening() {
    }
}