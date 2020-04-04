package com.hackaton.covid19.shared.adapters.data_access;

import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.register.domain.entities.PandeBuddy;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryPandeBuddyRepository implements FetchPandeBuddy, StorePandeBuddy {

    private final Map<Username, PandeBuddy> pandeBuddies;

    public InMemoryPandeBuddyRepository() {
        this.pandeBuddies = new HashMap<>();
    }

    @Override
    public Optional<PandeBuddy> withUsername(Username username) {
        if (pandeBuddies.containsKey(username)) {
            return Optional.of(pandeBuddies.get(username));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PandeBuddy withValues(PandeBuddy pandeBuddy) {
        if (exists(pandeBuddy.getUsername())) {
            throw new UserAlreadyRegisteredException(pandeBuddy.getUsername().value());
        }
        this.pandeBuddies.put(pandeBuddy.getUsername(), pandeBuddy);
        return pandeBuddy;
    }

    public int count() {
        return pandeBuddies.size();
    }
}
