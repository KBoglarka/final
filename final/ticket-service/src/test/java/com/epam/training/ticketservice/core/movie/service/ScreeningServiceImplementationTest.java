package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import com.epam.training.ticketservice.core.movie.repository.ScreeningRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
@TestExecutionListeners
@Transactional
class ScreeningServiceImplementationTest {

    private final static Screening ENTITY = new Screening(
            new Movie("How To Train Your Dragon", "animation", 98),
            new Room("A25", 10, 10),
            LocalDateTime.of(2024, 12, 10, 8,12));

    @Autowired
    private  ScreeningRepository screeningRepository = mock(ScreeningRepository.class);
    @Autowired
    private RoomRepository roomRepository = mock(RoomRepository.class);
    @Autowired
    private MovieRepository movieRepository = mock(MovieRepository.class);


    //private final ScreeningServiceImplementation underTest = new ScreeningServiceImplementation(screeningRepository);

    @Test
    void getAllScreenings() {
        /*MovieServiceImplementation movieservice = new MovieServiceImplementation(movieRepository);
        movieservice.createMovie("How To Train Your Dragon", "animation", 98);
        RoomServiceImplementation roomservice = new RoomServiceImplementation(roomRepository);
        roomservice.createRoom("A25", 10, 10);
        ScreeningServiceImplementation underTest = new ScreeningServiceImplementation(screeningRepository);
        underTest.createScreening(new Movie("How To Train Your Dragon", "animation", 98),
                new Room("A25", 10, 10),
                LocalDateTime.of(2024, 12, 10, 8,12));
        /*underTest.deleteScreening(new Movie("How To Train Your Dragon", "animation", 98),
                new Room("A25", 10, 10),
                LocalDateTime.of(2024, 12, 10, 8,12));

        List<Screening> actualscreenings = underTest.getAllScreenings();
        List<Screening> expectedscreenings = screeningRepository.findAll();
        Assertions.assertEquals(expectedscreenings, actualscreenings);*/
    }

    /*@Test
    void createScreening() {
        screeningRepository1.save(ENTITY);
        underTest.createScreening(
                new Movie("How To Train Your Dragon", "animation", 98),
                new Room("A25", 10, 10),
                LocalDateTime.of(2024, 12, 10, 8,12));
        List<Screening> screenings = screeningRepository1.findAll();
        List<Screening> screenings1 = screeningRepository.findAll();
        Assertions.assertEquals(screenings, screenings1);
    }

    @Test
    void deleteScreening() {
    }*/
}