package com.epam.training.ticketservice.core.movie.model.dto;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningDtoTest {

    private static final Movie HTTY = new Movie("How To Train Your Dragon", "animation", 98);
    private static final Room a10 = new Room("A10",10,10);
    private static final ScreeningDto SCREEN = new ScreeningDto(HTTY, a10, LocalDateTime.of(2024, 12, 10, 8,15));

    @Test
    void testToString() {
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
        assertEquals(newscreen, SCREEN);
    }
}