package com.hackaton.covid19.shared.adapters.data_access;

import com.hackaton.covid19.entryquestionnaire.CalculatedScore;
import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaire;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPandeBuddyRepository
        implements
        FetchPandeBuddy,
        StorePandeBuddy,
        FetchPandeBuddies {

    private final Map<Username, PandeBuddy> pandeBuddies;

    @Autowired
    public InMemoryPandeBuddyRepository() {

        this.pandeBuddies = new HashMap<>();

        this.pandeBuddies.put(Username.from("Gerry"), new PandeBuddy(Username.from("Gerry"), new PandeBuddies(new ArrayList<>()), "avatar1.png", new ScoreJson(100, "red", 12, true)));
        this.pandeBuddies.put(Username.from("Herbi"), new PandeBuddy(Username.from("Herbi"), new PandeBuddies(new ArrayList<>()), "avatar2.png", new ScoreJson(200, "red", 11, true)));
        this.pandeBuddies.put(Username.from("Manana"), new PandeBuddy(Username.from("Manana"), new PandeBuddies(new ArrayList<>()), "avatar3.png", new ScoreJson(300, "yellow", 6, false)));
        this.pandeBuddies.put(Username.from("Franzkarl"), new PandeBuddy(Username.from("Franzkarl"), new PandeBuddies(new ArrayList<>()), "avatar4.png", new ScoreJson(400, "yellow", 4, false)));
        this.pandeBuddies.put(Username.from("Hermann"), new PandeBuddy(Username.from("Hermann"), new PandeBuddies(new ArrayList<>()), "avatar5.png", new ScoreJson(500, "green", 0, false)));
        this.pandeBuddies.put(Username.from("Giorgi"), new PandeBuddy(Username.from("Giorgi"), new PandeBuddies(new ArrayList<>()), "avatar3.png", new ScoreJson(600, "green", 0, false)));
        this.pandeBuddies.put(Username.from("Ritz"), new PandeBuddy(Username.from("Ritz"), new PandeBuddies(new ArrayList<>()), "avatar6.png", new ScoreJson(600, "green", 0, false)));

        this.pandeBuddies.put(Username.from("Franzl"), new PandeBuddy(Username.from("Ritz"), new PandeBuddies(new ArrayList<>()), "avatar1.png", new ScoreJson(100, "red", 12, true)));
        this.pandeBuddies.put(Username.from("Knochi"), new PandeBuddy(Username.from("Knochi"), new PandeBuddies(new ArrayList<>()), "avatar2.png", new ScoreJson(200, "red", 11, true)));
        this.pandeBuddies.put(Username.from("Margarena"), new PandeBuddy(Username.from("Margarena"), new PandeBuddies(new ArrayList<>()), "avatar3.png", new ScoreJson(300, "yellow", 6, false)));
        this.pandeBuddies.put(Username.from("Hansipal"), new PandeBuddy(Username.from("Hansipal"), new PandeBuddies(new ArrayList<>()), "avatar4.png", new ScoreJson(400, "yellow", 4, false)));
        this.pandeBuddies.put(Username.from("Mikmak"), new PandeBuddy(Username.from("Mikmak"), new PandeBuddies(new ArrayList<>()), "avatar5.png", new ScoreJson(500, "green", 0, false)));
        this.pandeBuddies.put(Username.from("Letiko"), new PandeBuddy(Username.from("Letiko"), new PandeBuddies(new ArrayList<>()), "avatar3.png", new ScoreJson(600, "green", 0, false)));
        this.pandeBuddies.put(Username.from("Breuler"), new PandeBuddy(Username.from("Breuler"), new PandeBuddies(new ArrayList<>()), "avatar6.png", new ScoreJson(600, "green", 0, false)));

        Random random = new Random();
        this.pandeBuddies.values()
                .forEach(o -> {
                    var entryQuestionnaire = new EntryQuestionnaire(
                            "male",
                            random.nextInt(100),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextBoolean(),
                            random.nextInt(20),
                            random.nextBoolean(),
                            random.nextInt(20),
                            random.nextBoolean(),
                            random.nextInt(20),
                            new ArrayList<>(Set.of("Wear a mask when going out"))
                    );
                    o.setEntryQuestionnaire(entryQuestionnaire);
                    storePandeBuddy(o);

                    CalculatedScore calculatedScore = new CalculatedScore(entryQuestionnaire);
                    ScoreJson scoreValue = calculatedScore.value();

                    o.setScore(scoreValue);
                });
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
    public PandeBuddies searchPandeBuddies(Username pandename, Username buddyFragment) {
        Set<Username> usernames = pandeBuddies.keySet();
        List<PandeBuddy> pandeBuddiesOfPandeUser = pandeBuddies.get(pandename).getPandeBuddies().getPandeBuddies();
        List<PandeBuddy> pandeBuddiesProposalsList = new ArrayList<>();
        for (Username username : usernames) {
            if (username.value().contains(buddyFragment.value())
                    && !username.value().equalsIgnoreCase(pandename.value())
                    && !pandeBuddiesOfPandeUser.contains(pandeBuddies.get(username))) {
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
        if (!pandeBuddies.contains(newAddedPandeBuddy)) {
            pandeBuddies.add(newAddedPandeBuddy);
        }
        return newAddedPandeBuddy;
    }
}
