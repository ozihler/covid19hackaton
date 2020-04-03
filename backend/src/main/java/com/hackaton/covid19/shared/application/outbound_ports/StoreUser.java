package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.register.domain.entities.User;

public interface StoreUser {
    User withValues(User user);
}
