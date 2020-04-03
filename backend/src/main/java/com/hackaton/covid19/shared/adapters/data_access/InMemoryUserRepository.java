package com.hackaton.covid19.shared.adapters.data_access;

import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.register.domain.entities.User;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchUser;
import com.hackaton.covid19.shared.application.outbound_ports.StoreUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements FetchUser, StoreUser {

    private final Map<Username, User> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public Optional<User> withUsername(Username username) {
        if (users.containsKey(username)) {
            return Optional.of(users.get(username));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public User withValues(User user) {
        if (exists(user.getUsername())) {
            throw new UserAlreadyRegisteredException(user.getUsername().value());
        }
        this.users.put(user.getUsername(), user);
        return user;
    }
}
