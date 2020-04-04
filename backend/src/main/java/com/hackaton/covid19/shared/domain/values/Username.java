package com.hackaton.covid19.shared.domain.values;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Username username1 = (Username) o;
        return Objects.equals(username, username1.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
    }
}
