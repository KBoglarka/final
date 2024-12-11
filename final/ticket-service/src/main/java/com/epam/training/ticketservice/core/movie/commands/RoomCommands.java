package com.epam.training.ticketservice.core.movie.commands;

import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.RoomDto;
import com.epam.training.ticketservice.core.movie.service.RoomServiceImplementation;
import com.epam.training.ticketservice.core.user.model.User;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class RoomCommands {

    private final RoomServiceImplementation roomServiceImplementation;
    private final UserService userService;

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "create room", value = "Usage: <roomName> <rows> <columns>")
    protected RoomDto createRoom(String roomName, int rows, int columns){
        RoomDto room = new RoomDto(roomName, rows, columns);
        roomServiceImplementation.createRoom(room);
        return room;
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "update room", value = "Usage: <roomName> <rows> <columns>")
    protected RoomDto updateRoom(String roomName, int rows, int columns){
        RoomDto room = new RoomDto(roomName, rows, columns);
        roomServiceImplementation.updateRoom(room);
        return room;
    }

    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "delete room", value = "Usage: <roomName>")
    protected void deleteRoom(String roomName){
        roomServiceImplementation.deleteRoom(roomName);
    }

    @ShellMethod(key = "list rooms", value = "List all rooms.")
    public String listRooms(){
        if (roomServiceImplementation.getAllRooms() == null) {
            return "There are no rooms at the moment";
        };
        return roomServiceImplementation.getAllRooms().toString();
    }

    private Availability isAvailable(){
        Optional<UserDto> user = userService.describe();
        return user.isPresent() && user.get().role() == User.Role.ADMIN
                ? Availability.available()
                : Availability.unavailable("You are not an admin!");
    }


}
