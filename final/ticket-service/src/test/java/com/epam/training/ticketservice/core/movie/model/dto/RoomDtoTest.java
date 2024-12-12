package com.epam.training.ticketservice.core.movie.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomDtoTest {

    private static final RoomDto room = new RoomDto("A10", 10, 10);

    @Test
    void testToString() {
        assertEquals("Room A10 with 100 seats, 10 rows and 10 columns", room.toString());
    }

    @Test
    void roomName() {
        assertEquals(room.roomName(), "A10");
    }

    @Test
    void rows() {
        assertEquals(room.rows(), 10);
    }

    @Test
    void columns() {
        assertEquals(room.columns(), 10);
    }

    @Test
    void builder() {
        RoomDto newroom = RoomDto.builder().roomName("A10").rows(10).columns(10).build();
        assertEquals(newroom, room);
    }
}