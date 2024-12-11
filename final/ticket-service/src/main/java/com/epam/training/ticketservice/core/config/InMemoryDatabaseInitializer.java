package com.epam.training.ticketservice.core.config;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.repository.RoomRepository;
import com.epam.training.ticketservice.core.movie.repository.ScreeningRepository;
import com.epam.training.ticketservice.core.user.model.User;
import com.epam.training.ticketservice.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Profile("!prod")
public class InMemoryDatabaseInitializer {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;
    private final RoomRepository roomRepository;

    @PostConstruct
    public void init(){
        User admin = new User("admin", "admin", User.Role.ADMIN);
        userRepository.save(admin);

        Movie encanto = new Movie("Encanto", "family", 109);
        Movie hogfather = new Movie("Hogfather", "comedy", 193);
        Movie hmc = new Movie("Howl's Moving Castle", "fantasy", 119);
        movieRepository.save(encanto);
        movieRepository.save(hogfather);
        movieRepository.save(hmc);

        Room a10 = new Room("A10",10,10);
        Room a07 = new Room("A07",5,8);
        Room a01 = new Room("A01",15,10);
        roomRepository.save(a10);
        roomRepository.save(a07);
        roomRepository.save(a01);

        Screening morning = new Screening(encanto, a10, LocalDateTime.of(2024, 12, 10, 8,00));
        Screening night = new Screening(hmc, a01, LocalDateTime.of(2024, 12, 24, 18,00));
        screeningRepository.save(morning);
        screeningRepository.save(night);

    }

}
