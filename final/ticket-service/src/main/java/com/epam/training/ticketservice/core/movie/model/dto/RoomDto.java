package com.epam.training.ticketservice.core.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class RoomDto {
    private String roomName;
    private int rows;
    private int columns;

    @Override
    public String toString() {
        return "Room " + roomName + " with " + (rows*columns) + " seats, " + rows + " rows and " + columns + " columns";
    }
}
