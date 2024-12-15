package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreeningServiceImplementation implements ScreeningService{

    private final ScreeningRepository screeningRepository;


    @Override
    public List<Screening> getAllScreenings() {
        if(screeningRepository.count() == 0) {
            return null;
        }
        return screeningRepository.findAll()
                .stream()
                .toList();
    }

    @Override
    public void createScreening(Movie movie, Room room, LocalDateTime start) {
        screeningRepository.save(new Screening(movie, room, start));
    }

    @Override
    public void deleteScreening(Movie movie, Room room, LocalDateTime start) {
        var deletedscreening = screeningRepository.findScreeningByMovieAndRoom(movie, room);
        screeningRepository.delete((Screening) ((Optional<?>) deletedscreening).get());
    }


    /*private ScreeningDto mapEntityToDto(Screening screening) {
        return ScreeningDto.builder()
                .movie(screening.getMovie())
                .room(screening.getRoom())
                .startTime(screening.getStartTime())
                .build();
    }


    private Optional<ScreeningDto> mapEntityToDto(Optional<Screening> screening){
        return screening.map(this::mapEntityToDto);
    }*/
}
