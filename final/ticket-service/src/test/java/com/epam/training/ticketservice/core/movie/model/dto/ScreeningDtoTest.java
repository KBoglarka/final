package com.epam.training.ticketservice.core.movie.model.dto;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningDtoTest {

    private static final Movie HTTY = new Movie("How To Train Your Dragon", "animation", 98);
    private static final Movie HOGFATHER = new Movie("Hogfather", "comedy", 193);
    private static final Room a10 = new Room("A10",10,10);
    private static final Room a07 = new Room("A07",5,8);
    private static final ScreeningDto SCREEN = new ScreeningDto(HTTY, a10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SCREEN1 = new Screening(HTTY, a10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final ScreeningDto  SCREEN2 = new ScreeningDto(HOGFATHER, a10, LocalDateTime.of(2024, 12, 10, 8,15));

    @Test
    void testToString() {
        assertEquals("How To Train Your Dragon (animation, 98 minutes), screened in Room A10 with 100 seats, 10 rows and 10 columns, at 2024-12-10T08:15", SCREEN.toString());
    }

    @Test
    void movie() {
        assertEquals(SCREEN.movie(), HTTY);
    }

    @Test
    void room() {
        assertEquals(SCREEN.room(), a10);
    }

    @Test
    void startTime() {
        assertEquals(SCREEN.startTime(), LocalDateTime.of(2024, 12, 10, 8,15));
    }

    @Test
    void builder() {
        ScreeningDto newscreen = ScreeningDto.builder().movie(HTTY).room(a10).startTime(LocalDateTime.of(2024, 12, 10, 8,15)).build();
    }
}