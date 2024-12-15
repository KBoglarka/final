package com.epam.training.ticketservice.core.movie.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final Room A10 = new Room("A10",10,10);
    private static final Room A07 = new Room("A07",5,8);
    private static final Room SET = new Room("A07",5,8);

    @Test
    void testToString() {
    }

    @Test
    void getId() {
    }

    @Test
    void getRoomName() {
        assertEquals("A10", A10.getRoomName());
        assertEquals("A07", A07.getRoomName());
        assertFalse(A10.getRoomName().equals(A07.getRoomName()));
    }

    @Test
    void getRows() {
        assertEquals(10, A10.getRows());
        assertEquals(5, A07.getRows());
    }

    @Test
    void getColumns() {
        assertEquals(10, A10.getColumns());
        assertEquals(8, A07.getColumns());
    }

    @Test
    void setId() {
    }

    @Test
    void setRoomName() {
        SET.setRoomName("A11");
        assertEquals("A11", SET.getRoomName());
    }

    @Test
    void setRows() {
        SET.setRows(11);
        assertEquals(11, SET.getRows());
    }

    @Test
    void setColumns() {
        SET.setColumns(19);
        assertEquals(19, SET.getColumns());
    }

    @Test
    void testEquals() {
        assertFalse(A10.equals(A07));
    }

    @Test
    void canEqual() {
        assertTrue(A10.canEqual(A10));
    }

    @Test
    void testHashCode() {
        Room COPY = A10;
        assertNotEquals(A10.hashCode(), A07.hashCode());
        assertEquals(A10.hashCode(), COPY.hashCode());
    }
}