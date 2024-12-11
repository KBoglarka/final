package com.epam.training.ticketservice.core.movie.repository;

import com.epam.training.ticketservice.core.movie.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByroomName(String roomName);
}
