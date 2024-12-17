package com.epam.training.ticketservice.core.movie.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    private static final Movie HTTY = new Movie("How To Train Your Dragon", "animation", 98);
    private static final Movie HOGFATHER = new Movie("Hogfather", "comedy", 193);
    private static final Room A10 = new Room("A10",10,10);
    private static final Room A07 = new Room("A07",5,8);
    private static final Screening  SCREEN = new Screening(HTTY, A10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SCREEN1 = new Screening(HTTY, A10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SCREEN2 = new Screening(HOGFATHER, A10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SET = new Screening(HOGFATHER, A10, LocalDateTime.of(2024, 12, 10, 8,15));

    @Test
    void testToString() {
        assertEquals("How To Train Your Dragon (animation, 98 minutes), screened in room A10, at 2024-12-10 08:15", SCREEN.toString());
    }

    @Test
    void getId() {
    }

    @Test
    void getMovie() {
        assertEquals(HTTY, SCREEN.getMovie());
        assertNotEquals(HOGFATHER, SCREEN.getMovie());
    }

    @Test
    void getRoom() {
        assertEquals(A10, SCREEN.getRoom());
        assertNotEquals(A07, SCREEN.getRoom());
    }

    @Test
    void getStartTime() {
        assertEquals(LocalDateTime.of(2024, 12, 10, 8, 15), SCREEN.getStartTime());
    }

    @Test
    void setId() {
    }

    @Test
    void setMovie() {
        SET.setMovie(HOGFATHER);
        assertEquals(HOGFATHER, SET.getMovie());
    }

    @Test
    void setRoom() {
        SET.setRoom(A07);
        assertEquals(A07, SET.getRoom());
    }

    @Test
    void setStartTime() {
        SET.setStartTime(LocalDateTime.of(2024, 12, 10, 8, 10));
        assertEquals(LocalDateTime.of(2024, 12, 10, 8, 10), SET.getStartTime());
    }

    @Test
    void testNoArgsConstructor() {
        Screening screening = new Screening();
        Movie movie = null;
        Room room = null;
        LocalDateTime time = null;
        assertEquals(movie, screening.getMovie());
        assertEquals(room, screening.getRoom());
        assertEquals(time, screening.getStartTime());
    }

    @Test
    void testEquals() {
        assertNotEquals(SCREEN, SCREEN2);
        assertEquals(SCREEN, SCREEN1);
        assertTrue(SCREEN.equals(SCREEN1));
        assertFalse(SCREEN == SCREEN1);
        assertNotEquals(SCREEN, HTTY);
        assertFalse(SCREEN.equals(null));
    }

    @Test
    void canEqual() {
        assertTrue(SCREEN.canEqual(SCREEN));
    }

    @Test
    void testHashCode() {
        Screening copy = SCREEN2;
        assertNotEquals(SCREEN.hashCode(), SCREEN2.hashCode());
        assertEquals(SCREEN2.hashCode(), copy.hashCode());
    }
}