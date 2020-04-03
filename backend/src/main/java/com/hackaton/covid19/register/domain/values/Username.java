package com.hackaton.covid19.register.domain.values;

public class Username {

    private String username;

    public Username(String username) {
        this.username = username;
    }

    public static Username from(String username) {
        return new Username(username);
    }

    public String value() {
        return username;
    }
}
