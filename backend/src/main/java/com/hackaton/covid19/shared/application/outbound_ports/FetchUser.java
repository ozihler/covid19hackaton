package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.register.domain.entities.User;
import com.hackaton.covid19.register.domain.values.Username;

import java.util.Optional;

public interface FetchUser {
    default boolean exists(Username username) {
        return withUsername(username).isPresent();
    }

    Optional<User> withUsername(Username username);
}
