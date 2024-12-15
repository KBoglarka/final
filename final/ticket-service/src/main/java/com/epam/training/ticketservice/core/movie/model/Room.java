package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOM")
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

    public Room(){

    }


    @Override
    public String toString() {
        return "Room " + roomName + " with " + (rows*columns) + " seats, " + rows + " rows and " + columns + " columns";
    }
}
