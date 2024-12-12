package com.epam.training.ticketservice.core.movie.model.dto;
import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ScreeningDto(Movie movie, Room room, LocalDateTime startTime) {

    @Override
    public String toString() {
        return movie.toString() + ", screened in " + room.toString() + ", at " + startTime.toString();
    }

    //<A film címe> (<műfaj>, <vetítés ideje percben> minutes), screened in room <terem neve>, at <vetítés kezdetének dátuma és ideje, YYYY-MM-DD hh:mm formátumban>
}
