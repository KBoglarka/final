package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.RoomDto;
import com.epam.training.ticketservice.core.movie.service.RoomServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class RoomCommands {

    private final RoomServiceImplementation roomServiceImplementation;

    @ShellMethod(key = "create room", value = "Usage: <roomName> <rows> <columns>")
    public RoomDto createRoom(String roomName, int rows, int columns){
        RoomDto room = new RoomDto(roomName, rows, columns);
        roomServiceImplementation.createRoom(room);
        return room;
    }

    @ShellMethod(key = "update room", value = "Usage: <roomName> <rows> <columns>")
    public RoomDto updateRoom(String roomName, int rows, int columns){
        RoomDto room = new RoomDto(roomName, rows, columns);
        roomServiceImplementation.updateRoom(room);
        return room;
    }

    @ShellMethod(key = "delete room", value = "Usage: <roomName>")
    public void deleteRoom(String roomName){
        roomServiceImplementation.deleteRoom(roomName);
    }

    @ShellMethod(key = "list rooms", value = "List all rooms.")
    public String listRooms(){
        if (roomServiceImplementation.getAllRooms() == null) {
            return "There are no rooms at the moment";
        };
        return roomServiceImplementation.getAllRooms().toString();
    }


}
