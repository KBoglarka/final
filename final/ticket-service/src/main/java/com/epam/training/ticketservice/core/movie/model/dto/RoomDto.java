package com.epam.training.ticketservice.core.movie.model.dto;

import lombok.Builder;

@Builder
public record RoomDto(String roomName, int rows, int columns) {

    @Override
    public String toString() {
        return "Room " + roomName + " with " + (rows * columns)
                + " seats, " + rows + " rows and " + columns + " columns";
    }
}
