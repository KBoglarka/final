package com.epam.training.ticketservice.core.movie.service;

public interface RoomService {

    void createRoom(String roomName, int rows, int columns);
    void updateRoom(String roomName, int rows, int columns);
    void deleteRoom(String roomName);
}
