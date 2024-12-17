package com.epam.training.ticketservice.core.user.commands;

import com.epam.training.ticketservice.core.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class UserCommands {

    private final UserService userService;

    @ShellMethod(key = "describe account", value = "account information")
    public String describe(){

        return userService.describe().map(Record::toString).orElse("You are not signed in");
    }
}
