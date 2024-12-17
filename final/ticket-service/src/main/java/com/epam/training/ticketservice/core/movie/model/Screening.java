package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SCREENING")
@Transactional
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Room room;
    private LocalDateTime startTime;

    public Screening(Movie movie, Room room, LocalDateTime startTime) {
        this.movie = movie;
        this.room = room;
        this.startTime = startTime;
    }

    public Screening() {

    }

    @Override
    public String toString() {
        return movie.toString() + ", screened in room " + room.getRoomName() + ", at " + startTime.toString().replace('T', ' ');
    }
}
