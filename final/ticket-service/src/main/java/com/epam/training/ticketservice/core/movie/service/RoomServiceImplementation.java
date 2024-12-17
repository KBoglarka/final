package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImplementation implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        if (roomRepository.count() == 0) {
            return null;
        }
        return roomRepository.findAll()
                .stream()
                .toList();
    }

    @Override
    public void createRoom(String roomName, int rows, int columns) {
        roomRepository.save(new Room(roomName, rows, columns));
    }

    @Override
    public void updateRoom(String roomName, int rows, int columns) {
        var updatedRoom = roomRepository.findByroomName(roomName);
        if (updatedRoom.isPresent()) {
            updatedRoom.get().setRows(rows);
            updatedRoom.get().setColumns(columns);
            roomRepository.save(updatedRoom.get());
        }
    }


    @Override
    public void deleteRoom(String roomName) {
        var deletedRoom = roomRepository.findByroomName(roomName);
        roomRepository.delete(deletedRoom.get());
    }

}
