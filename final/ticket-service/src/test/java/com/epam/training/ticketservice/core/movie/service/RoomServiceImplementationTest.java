package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RoomServiceImplementationTest {

    private final static Room ENTITY = new Room("A25", 10, 10);
    private final RoomRepository roomRepository = mock(RoomRepository.class);
    private final RoomRepository roomRepository1 = mock(RoomRepository.class);
    private final RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
    @Test
    void getAllRooms() {
        roomRepository1.save(ENTITY);
        Room room1 = new Room("A25", 10, 10);
        roomRepository.save(room1);
        List<Room> rooms = roomRepository1.findAll();
        List<Room> rooms1 = roomRepository.findAll();

        Assertions.assertEquals(rooms, rooms1);
    }

    @Test
    void createRoom() {
        roomRepository1.save(ENTITY);
        underTest.createRoom("A25", 10, 10);
        List<Room> rooms = roomRepository1.findAll();
        List<Room> rooms1 = roomRepository.findAll();
        Assertions.assertEquals(rooms, rooms1);
    }

    @Test
    void updateRoom() {
        roomRepository.save(ENTITY);
        underTest.updateRoom("A25", 10, 15);
        Room room1 = new Room("A25", 10, 15);
        roomRepository1.save(room1);
        List<Room> rooms = roomRepository1.findAll();
        List<Room> rooms1 = roomRepository.findAll();
        Assertions.assertEquals(rooms, rooms1);
    }

    @Test
    void deleteRoom() {
    }
}