package com.epam.training.ticketservice.core.movie.model.dto;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class ScreeningDto {
    private Movie movie;
    private Room room;
    private LocalDateTime startTime;

    @Override
    public String toString() {
        return movie.toString() + ", screened in " + room.toString() + ", at " + startTime.toString() + "\n";
    }

    //<A film címe> (<műfaj>, <vetítés ideje percben> minutes), screened in room <terem neve>, at <vetítés kezdetének dátuma és ideje, YYYY-MM-DD hh:mm formátumban>
}
