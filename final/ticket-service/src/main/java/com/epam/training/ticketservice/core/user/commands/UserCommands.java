package com.epam.training.ticketservice.core.user.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class UserCommands {

    @ShellMethod(key = "describe account", value = "account information")
    public String describe(){
        return "";
    }
}
