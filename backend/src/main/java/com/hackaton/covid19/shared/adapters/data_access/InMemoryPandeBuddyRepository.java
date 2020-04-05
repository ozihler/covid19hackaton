package com.hackaton.covid19.shared.adapters.data_access;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Score;
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
        pandeBuddies.add(new PandeBuddy(Username.from("Olly"), new PandeBuddies(List.of()), "avatar1.png", new ScoreJson(100, "red", 12,true)));
        pandeBuddies.add(new PandeBuddy(Username.from("Monique"), new PandeBuddies(List.of()), "avatar2.png", new ScoreJson(200, "red", 11,true)));
        pandeBuddies.add(new PandeBuddy(Username.from("Sandro"), new PandeBuddies(List.of()), "avatar3.png", new ScoreJson(300, "yellow", 6,false)));
        pandeBuddies.add(new PandeBuddy(Username.from("Simona"), new PandeBuddies(List.of()), "avatar4.png", new ScoreJson(400, "yellow", 4,false)));
        pandeBuddies.add(new PandeBuddy(Username.from("Fabian"), new PandeBuddies(List.of()), "avatar5.png", new ScoreJson(500, "green", 0,false)));
        pandeBuddies.add(new PandeBuddy(Username.from("Hannah"), new PandeBuddies(List.of()), "avatar6.png", new ScoreJson(600, "green", 0,false)));

        PandeBuddy alina = new PandeBuddy(Username.from("Alina"), new PandeBuddies(pandeBuddies), "avatar7.png", new ScoreJson(500, "yellow", 7,false));

        List<PandeBuddy> buddiesOfMonique = new ArrayList<>();
        PandeBuddy monique = new PandeBuddy(Username.from("Monique"), new PandeBuddies(buddiesOfMonique), "avatar2.png", new ScoreJson(200, "red", 11,true));
        PandeBuddy olly = new PandeBuddy(Username.from("Olly"), new PandeBuddies(List.of(monique)), "avatar1.png", new ScoreJson(100, "red", 12,true));
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

    public int count() {
        return pandeBuddies.size();
    }

    @Override
    public PandeBuddy storePandeBuddy(PandeBuddy pandeBuddy) {
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

    @Override
    public PandeBuddies searchPandeBuddies(Username usernameFragment){
        Set<Username> usernames = pandeBuddies.keySet();
        List<PandeBuddy> pandeBuddiesProposalsList = new ArrayList<>();
        for (Username username:usernames) {
            if(username.value().contains(usernameFragment.value())){
                pandeBuddiesProposalsList.add(pandeBuddies.get(username));
            }
        }
        return new PandeBuddies(pandeBuddiesProposalsList);
    }

    @Override
    public PandeBuddy addToPandeBuddies(Username newBuddyUsername, Username username) {
        if (!exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }
        if (!exists(newBuddyUsername)) {
            throw new PandeBuddyNotFoundException(newBuddyUsername);
        }
        PandeBuddy pandeBuddy = pandeBuddies.get(username);
        PandeBuddy newAddedPandeBuddy = pandeBuddies.get(newBuddyUsername);
        List<PandeBuddy> pandeBuddies = pandeBuddy.getPandeBuddies().getPandeBuddies();
        if(!pandeBuddies.contains(newAddedPandeBuddy)){
            pandeBuddies.add(newAddedPandeBuddy);
        }
        return newAddedPandeBuddy;
    }
}
