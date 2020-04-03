package com.hackaton.covid19.register.application.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {

    public UserAlreadyRegisteredException(String username) {
        super("User is already registered: " + username);
    }
}
