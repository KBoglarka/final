package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.RoomDto;
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
    public List<RoomDto> getAllRooms() {
        if(roomRepository.count() == 0) {
            return null;
        }
        return roomRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    @Override
    public void createRoom(RoomDto roomDto) {
        Room room = new Room(
                roomDto.getRoomName(),
                roomDto.getRows(),
                roomDto.getColumns()
        );
        roomRepository.save(room);
    }

    @Override
    public void updateRoom(RoomDto roomDto) {
        var updatedRoom = roomRepository.findByroomName(roomDto.getRoomName());
        if (updatedRoom.isPresent()) {
            updatedRoom.get().setRows(roomDto.getRows());
            updatedRoom.get().setColumns(roomDto.getColumns());
            roomRepository.save(updatedRoom.get());
        }
    }

    @Override
    public void deleteRoom(String roomName) {
        var deletedRoom = roomRepository.findByroomName(roomName);
        roomRepository.delete(deletedRoom.get());
    }

    private RoomDto mapEntityToDto(Room room) {
        return RoomDto.builder()
                .roomName(room.getRoomName())
                .rows(room.getRows())
                .columns(room.getColumns())
                .build();
    }


    private Optional<RoomDto> mapEntityToDto(Optional<Room> room){
        return room.map(this::mapEntityToDto);
    }
}
