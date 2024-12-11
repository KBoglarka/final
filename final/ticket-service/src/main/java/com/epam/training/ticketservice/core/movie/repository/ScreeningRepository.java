package com.epam.training.ticketservice.core.movie.repository;

import com.epam.training.ticketservice.core.movie.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}