package com.epam.training.ticketservice.core.movie.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MovieDtoTest {

    private static final MovieDto movie = new MovieDto("Film", "akció", 130);

    @Test
    void testToString() {
        assertEquals(movie.toString(),"Film (akció, 130 minutes)");
    }

    @Test
    void movieName() {
        assertEquals(movie.movieName(),"Film");
    }

    @Test
    void movieCategory() {
        assertEquals(movie.movieCategory(),"akció");
    }

    @Test
    void movieLength() {
        assertEquals(movie.movieLength(),130);
    }

    @Test
    void builder() {
        MovieDto newmovie = MovieDto.builder().movieName("Film").movieCategory("akció").movieLength(130).build();
        assertEquals(newmovie, movie);
    }
}