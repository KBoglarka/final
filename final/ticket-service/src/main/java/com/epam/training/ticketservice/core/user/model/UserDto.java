package com.epam.training.ticketservice.core.user.model;

public record UserDto(String username, User.Role role) {

    @Override
    public String toString() {
        return "Signed in with privileged account '" + username + "'";
    }
}
