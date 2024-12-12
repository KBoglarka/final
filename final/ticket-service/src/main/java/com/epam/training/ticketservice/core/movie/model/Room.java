package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOM")
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomName;
    private int rows;
    private int columns;

    public Room(String name, int rows, int columns) {
        this.roomName = name;
        this.rows = rows;
        this.columns = columns;
    }


    @Override
    public String toString() {
        return "Room " + roomName + " with " + (rows*columns) + " seats, " + rows + " rows and " + columns + " columns";
    }
}
