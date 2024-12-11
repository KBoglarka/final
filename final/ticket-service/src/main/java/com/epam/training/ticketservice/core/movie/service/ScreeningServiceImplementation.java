package com.epam.training.ticketservice.core.movie.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.model.Room;
import com.epam.training.ticketservice.core.movie.model.Screening;
import com.epam.training.ticketservice.core.movie.model.dto.MovieDto;
import com.epam.training.ticketservice.core.movie.model.dto.ScreeningDto;
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
    public List<ScreeningDto> getAllScreenings() {
        if(screeningRepository.count() == 0) {
            return null;
        }
        return screeningRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .toList();
    }

    @Override
    public void createScreening(ScreeningDto screeningDto) {
        Screening screening = new Screening(
                screeningDto.getMovie(),
                screeningDto.getRoom(),
                screeningDto.getStartTime()
        );
        screeningRepository.save(screening);
    }

    @Override
    public void deleteScreening(ScreeningDto screeningDto) {
        var deletedscreening = screeningRepository.findScreeningByMovieAndRoom(screeningDto.getMovie(), screeningDto.getRoom());
        screeningRepository.delete(deletedscreening.get());
    }


    private ScreeningDto mapEntityToDto(Screening screening) {
        return ScreeningDto.builder()
                .movie(screening.getMovie())
                .room(screening.getRoom())
                .startTime(screening.getStartTime())
                .build();
    }


    private Optional<ScreeningDto> mapEntityToDto(Optional<Screening> screening){
        return screening.map(this::mapEntityToDto);
    }
}
