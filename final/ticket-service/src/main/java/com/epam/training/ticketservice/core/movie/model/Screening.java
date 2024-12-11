package com.epam.training.ticketservice.core.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SCREENING")
@NoArgsConstructor
@Transactional
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name= "MOVIE_ID", referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name= "ROOM_ID", referencedColumnName = "id")
    private Room room;
    private LocalDateTime startTime;

    public Screening(Movie movie, Room room, LocalDateTime startTime) {
        this.movie = movie;
        this.room = room;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return movie.toString() + ", screened in " + room.toString() + ", at " + startTime.toString();
    }
}
