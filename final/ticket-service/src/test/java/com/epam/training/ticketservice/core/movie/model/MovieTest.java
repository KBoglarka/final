package com.epam.training.ticketservice.core.movie.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MovieTest {

    private static final Movie HTTY = new Movie("How To Train Your Dragon", "animation", 98);
    private static final Movie HOGFATHER = new Movie("Hogfather", "comedy", 193);
    private static final Movie ENCANTO = new Movie("Encanto", "animation", 94);


    @Test
    void testToString() {
    }

    @Test
    void testGetId() {
    }

    @Test
    void testGetMovieName() {
        assertEquals("How To Train Your Dragon", HTTY.getMovieName());
        assertEquals("Hogfather", HOGFATHER.getMovieName());
        assertFalse(HTTY.getMovieName() == HOGFATHER.getMovieName());
    }

    @Test
    void testGetMovieCategory() {
        assertEquals("comedy", HOGFATHER.getMovieCategory());
        assertEquals("animation", HTTY.getMovieCategory());
        assertFalse(HTTY.getMovieCategory() == HOGFATHER.getMovieCategory());
    }

    @Test
    void testgetMovieLength() {
        assertEquals(98, HTTY.getMovieLength());
        assertEquals(193, HOGFATHER.getMovieLength());
        assertFalse(HTTY.getMovieLength() == HOGFATHER.getMovieLength());
    }

    @Test
    void testSetId() {
    }

    @Test
    void testSetMovieName() {
        HTTY.setMovieName("How To Train Your Dragon 2");
        assertEquals("How To Train Your Dragon 2", HTTY.getMovieName());
        HTTY.setMovieName("How To Train Your Dragon");
        assertEquals("How To Train Your Dragon", HTTY.getMovieName());
    }

    @Test
    void testSetMovieCategory() {
        HTTY.setMovieCategory("action");
        assertEquals("action", HTTY.getMovieCategory());
        HTTY.setMovieCategory("action");
    }

    @Test
    void testSetMovieLength() {
        HOGFATHER.setMovieLength(190);
        assertEquals(190, HOGFATHER.getMovieLength());
        HOGFATHER.setMovieLength(193);
    }

    @Test
    void testEquals() {
        assertFalse(HTTY.equals(HOGFATHER));
        assertTrue(ENCANTO.equals(ENCANTO));
        assertTrue(ENCANTO == ENCANTO);
        assertFalse(ENCANTO == HTTY);
        assertFalse(HTTY.equals(null));
        assertTrue(ENCANTO != HTTY);
        assertTrue(!HTTY.equals(ENCANTO));
    }

    @Test
    void testCanEqual() {
        assertTrue(ENCANTO.canEqual(ENCANTO));
        assertFalse(!ENCANTO.equals(ENCANTO));
        assertTrue(!ENCANTO.canEqual(null));

    }

    @Test
    void testHashCode() {
        Movie copy = ENCANTO;
        assertNotEquals(HTTY.hashCode(), HOGFATHER.hashCode());
        assertEquals(ENCANTO.hashCode(), copy.hashCode());
    }
}