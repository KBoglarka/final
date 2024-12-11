package com.epam.training.ticketservice.core.user.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AccountCommands {

    @ShellMethod(key = "sign in privileged", value = "Administrator sign in")
    public String logInAdmin(String username, String password) {
        return "";
    }

    @ShellMethod(key = "sign out", value = "Administrator sign out")
    public String signOut(){
        return "";
    }
}
