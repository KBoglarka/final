package com.epam.training.ticketservice.core.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class MovieDto {
    private String movieName;
    private String movieCategory;
    private int movieLength;

    @Override
    public String toString() {
        return movieName + " (" + movieCategory + ", " + movieLength + " minutes)\n";
    }
}
