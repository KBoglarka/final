package com.epam.training.ticketservice.core.movie.repository;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    Optional<Screening> findScreeningByMovieAndRoom(Movie movie, Room room);
}
