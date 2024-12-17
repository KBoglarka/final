package com.epam.training.ticketservice.core.movie.model.dto;

import lombok.Builder;

@Builder
public record MovieDto(String movieName, String movieCategory, int movieLength) {

    @Override
    public String toString() {
        return movieName + " (" + movieCategory + ", " + movieLength + " minutes)";
    }
}
