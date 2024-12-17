package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class RoomServiceImplementationTest {

    private static final Room ENTITY = new Room("A25", 10, 10);

    @Autowired
    private RoomRepository roomRepository = mock(RoomRepository.class);

    //private final RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);

    @Test
    void getAllRooms() {
        RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
        underTest.createRoom("A25", 10, 10);
        List<Room> actualrooms = underTest.getAllRooms();
        List<Room> expectedrooms = roomRepository.findAll();
        assertEquals(expectedrooms, actualrooms);
    }

    @Test
    void getAllRoomsNull() {
        RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
        assertEquals(underTest.getAllRooms(), null);
    }

    @Test
    void createRoom() {
        RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
        underTest.createRoom("A25", 10, 10);
        Assertions.assertEquals(underTest.getAllRooms().size(), 1);
    }

    @Test
    void updateRoom() {
        RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
        underTest.createRoom("A25", 10, 10);
        underTest.updateRoom("A25", 10, 20);
        underTest.updateRoom("A20", 10, 20);
        Assertions.assertEquals(underTest.getAllRooms().size(), 1);
    }

    @Test
    void deleteRoom() {
        RoomServiceImplementation underTest = new RoomServiceImplementation(roomRepository);
        underTest.createRoom("A25", 10, 10);
        underTest.deleteRoom("A25");
        Assertions.assertEquals(underTest.getAllRooms(), null);
    }
}