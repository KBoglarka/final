package com.epam.training.ticketservice.core.movie.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    private static final Movie HTTY = new Movie("How To Train Your Dragon", "animation", 98);
    private static final Movie HOGFATHER = new Movie("Hogfather", "comedy", 193);
    private static final Room a10 = new Room("A10",10,10);
    private static final Room a07 = new Room("A07",5,8);
    private static final Screening  SCREEN = new Screening(HTTY, a10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SCREEN1 = new Screening(HTTY, a10, LocalDateTime.of(2024, 12, 10, 8,15));
    private static final Screening  SCREEN2 = new Screening(HOGFATHER, a10, LocalDateTime.of(2024, 12, 10, 8,15));

    @Test
    void testToString() {
        assertEquals("How To Train Your Dragon (animation, 98 minutes), screened in Room A10 with 100 seats, 10 rows and 10 columns, at 2024-12-10T08:15", SCREEN.toString());
    }

    @Test
    void getMovie() {
        assertEquals(HTTY, SCREEN.getMovie());
        assertNotEquals(HOGFATHER, SCREEN.getMovie());
    }

    @Test
    void getRoom() {
        assertEquals(a10, SCREEN.getRoom());
        assertNotEquals(a07, SCREEN.getRoom());
    }

    @Test
    void getStartTime() {
        assertEquals(LocalDateTime.of(2024, 12, 10, 8, 15), SCREEN.getStartTime());
    }

    @Test
    void setMovie() {
        SCREEN.setMovie(HOGFATHER);
        assertEquals(HOGFATHER, SCREEN.getMovie());
        SCREEN.setMovie(HTTY);
    }

    @Test
    void setRoom() {
        SCREEN.setRoom(a07);
        assertEquals(a07, SCREEN.getRoom());
        SCREEN.setRoom(a10);
    }

    @Test
    void setStartTime() {
        SCREEN.setStartTime(LocalDateTime.of(2024, 12, 10, 8, 10));
        assertEquals(LocalDateTime.of(2024, 12, 10, 8, 10), SCREEN.getStartTime());
        SCREEN.setStartTime(LocalDateTime.of(2024, 12, 10, 8, 15));
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
    void testCanEqual(){
        assertTrue(SCREEN.canEqual(SCREEN));
    }

    @Test
    void testHashCode() {
        Screening copy = SCREEN2;
        assertNotEquals(SCREEN.hashCode(), SCREEN2.hashCode());
        assertEquals(SCREEN2.hashCode(), copy.hashCode());
    }
}