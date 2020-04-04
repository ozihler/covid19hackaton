package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;

import java.util.Optional;

public interface FetchPandeBuddy {
    default boolean exists(Username username) {
        return withUsername(username).isPresent();
    }

    Optional<PandeBuddy> withUsername(Username username);
}
