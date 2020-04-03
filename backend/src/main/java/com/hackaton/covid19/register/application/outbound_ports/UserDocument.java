package com.hackaton.covid19.register.application.outbound_ports;

import com.hackaton.covid19.register.domain.values.Username;

public class UserDocument {

    private Username username;

    public UserDocument(Username username) {
        this.username = username;
    }

    public Username getUsername() {
        return username;
    }
}
