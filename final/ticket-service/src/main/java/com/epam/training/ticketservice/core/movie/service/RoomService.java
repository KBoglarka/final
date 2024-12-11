package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAllRooms();

    void createRoom(RoomDto roomDto);
    void updateRoom(RoomDto roomDto);
    void deleteRoom(String roomName);
}
