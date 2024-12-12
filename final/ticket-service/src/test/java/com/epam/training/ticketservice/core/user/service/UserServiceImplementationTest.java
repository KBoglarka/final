package com.epam.training.ticketservice.core.user.service;

import com.epam.training.ticketservice.core.movie.model.Movie;
import com.epam.training.ticketservice.core.movie.repository.MovieRepository;
import com.epam.training.ticketservice.core.movie.service.MovieServiceImplementation;
import com.epam.training.ticketservice.core.user.model.User;
import com.epam.training.ticketservice.core.user.model.UserDto;
import com.epam.training.ticketservice.core.user.repository.UserRepository;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceImplementationTest {

    private static final User ENTITY = new User("admin", "admin", User.Role.ADMIN);
    private static final UserDto ENTITY2 = new UserDto("admin", User.Role.ADMIN);
    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserRepository userRepository1 = mock(UserRepository.class);
    private final UserServiceImplementation underTest = new UserServiceImplementation(userRepository);

    @Test
    void login() {

    }

    @Test
    void logout() {
    }

    @Test
    void describe() {
    }

    @Test
    void registerUser() {
    }
}