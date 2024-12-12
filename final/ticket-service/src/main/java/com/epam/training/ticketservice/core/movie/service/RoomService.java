package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    void createRoom(String roomName, int rows, int columns);
    void updateRoom(String roomName, int rows, int columns);
    void deleteRoom(String roomName);
}
