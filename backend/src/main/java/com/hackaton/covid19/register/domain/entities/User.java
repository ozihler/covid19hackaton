package com.hackaton.covid19.register.domain.entities;

import com.hackaton.covid19.register.domain.values.Username;

public class User {

    private Username username;

    public User(Username username) {
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }
}
