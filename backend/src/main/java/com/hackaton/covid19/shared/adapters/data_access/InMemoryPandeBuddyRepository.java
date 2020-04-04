package com.hackaton.covid19.shared.adapters.data_access;

import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPandeBuddyRepository
        implements
        FetchPandeBuddy,
        StorePandeBuddy,
        FetchPandeBuddies {

    private final Map<Username, PandeBuddy> pandeBuddies;

    public InMemoryPandeBuddyRepository() {
        this.pandeBuddies = new HashMap<>();


        List<PandeBuddy> pandeBuddies = new ArrayList<>();
        pandeBuddies.add(new PandeBuddy(Username.from("Olly"), new PandeBuddies(List.of())));
        pandeBuddies.add(new PandeBuddy(Username.from("Monique"), new PandeBuddies(List.of())));
        pandeBuddies.add(new PandeBuddy(Username.from("Sandro"), new PandeBuddies(List.of())));
        pandeBuddies.add(new PandeBuddy(Username.from("Simona"), new PandeBuddies(List.of())));
        pandeBuddies.add(new PandeBuddy(Username.from("Fabian"), new PandeBuddies(List.of())));
        pandeBuddies.add(new PandeBuddy(Username.from("Hannah"), new PandeBuddies(List.of())));

        PandeBuddy alina = new PandeBuddy(Username.from("Alina"), new PandeBuddies(pandeBuddies));

        List<PandeBuddy> buddiesOfMonique = new ArrayList<>();
        PandeBuddy monique = new PandeBuddy(Username.from("Monique"), new PandeBuddies(buddiesOfMonique));
        PandeBuddy olly = new PandeBuddy(Username.from("Olly"), new PandeBuddies(List.of(monique)));
        buddiesOfMonique.add(olly);

        this.pandeBuddies.put(alina.getUsername(), alina);
        this.pandeBuddies.put(olly.getUsername(), olly);
        this.pandeBuddies.put(monique.getUsername(), monique);
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

    @Override
    public PandeBuddies forPandeBuddy(Username username) {
        if (!exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }

        PandeBuddy pandeBuddy = pandeBuddies.get(username);

        return pandeBuddy.getPandeBuddies();
    }

    public int count() {
        return pandeBuddies.size();
    }
}
