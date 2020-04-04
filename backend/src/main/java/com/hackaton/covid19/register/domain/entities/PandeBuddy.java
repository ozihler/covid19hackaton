package com.hackaton.covid19.register.domain.entities;

import com.hackaton.covid19.register.domain.values.Username;

public class PandeBuddy {

    private Username username;

    public PandeBuddy(Username username) {
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }
}
