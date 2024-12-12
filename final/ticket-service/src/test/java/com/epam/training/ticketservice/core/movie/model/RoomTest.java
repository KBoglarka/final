package com.epam.training.ticketservice.core.movie.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private static final Room a10 = new Room("A10",10,10);
    private static final Room a07 = new Room("A07",5,8);

    @Test
    void testToString() {
        //return "Room " + roomName + " with " + (rows*columns) + " seats, " + rows + " rows and " + columns + " columns";
        assertEquals("Room A10 with 100 seats, 10 rows and 10 columns", a10.toString());
    }

    @Test
    void getRoomName() {
        assertEquals("A10", a10.getRoomName());
        assertEquals("A07", a07.getRoomName());
        assertFalse(a10.getRoomName().equals(a07.getRoomName()));
    }

    @Test
    void getRows() {
        assertEquals(10, a10.getRows());
        assertEquals(5, a07.getRows());
    }

    @Test
    void getColumns() {
        assertEquals(10, a10.getColumns());
        assertEquals(8, a07.getColumns());
    }

    @Test
    void setRoomName() {
        a10.setRoomName("A11");
        assertEquals("A11", a10.getRoomName());
        a10.setRoomName("A10");
    }

    @Test
    void setRows() {
        a10.setRows(11);
        assertEquals(11, a10.getRows());
        a10.setRows(10);
    }

    @Test
    void setColumns() {
        a10.setColumns(19);
        assertEquals(19, a10.getColumns());
        a10.setColumns(10);
    }

    @Test
    void testEquals() {
        assertFalse(a10.equals(a07));
    }

    @Test
    void testCanEqual(){
        assertTrue(a10.canEqual(a10));
    }

    @Test
    void testHashCode() {
        Room copy = a10;
        assertNotEquals(a10.hashCode(), a07.hashCode());
        assertEquals(a10.hashCode(), copy.hashCode());
    }
}