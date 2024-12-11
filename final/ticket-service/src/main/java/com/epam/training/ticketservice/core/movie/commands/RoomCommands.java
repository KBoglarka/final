package com.epam.training.ticketservice.core.movie.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class RoomCommands {

    @ShellMethod(key = "create room", value = "Usage: <roomName> <rows> <columns>")
    public String createRoom(String roomName, int rows, int columns){
        return "";
    }

    @ShellMethod(key = "update room", value = "Usage: <roomName> <rows> <columns>")
    public String updateRoom(String roomName, int rows, int columns){
        return "";
    }

    @ShellMethod(key = "delete room", value = "Usage: <roomName>")
    public String deleteRoom(String roomName){
        return "";
    }

    @ShellMethod(key = "list rooms", value = "List all rooms.")
    public String listRooms(){
        return "";
    }


}
