package com.epam.training.ticketservice.core.user.commands;

import com.epam.training.ticketservice.core.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class AccountCommands {

    private final UserService userService;

    @ShellMethod(key = "sign in privileged", value = "Administrator sign in")
    public String logInAdmin(String username, String password) {
        return userService.login(username, password).map(userDto -> userDto + "is successfully logged in!")
                .orElse("Login failed due to incorrect credentials");
    }

    @ShellMethod(key = "sign out", value = "Administrator sign out")
    public String signOut(){
        return userService.logout().map(userDto -> userDto + "is logged out")
                .orElse("You need to log in first!");
    }
}
