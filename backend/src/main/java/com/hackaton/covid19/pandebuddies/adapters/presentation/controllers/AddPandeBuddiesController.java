package com.hackaton.covid19.pandebuddies.adapters.presentation.controllers;

import com.hackaton.covid19.entryquestionnaire.CalculatedScore;
import com.hackaton.covid19.pandebuddies.adapters.presentation.presenters.JsonPandeBuddiesPresenter;
import com.hackaton.covid19.pandebuddies.application.use_cases.PandeBuddiesUseCase;
import com.hackaton.covid19.pandebuddies.application.use_cases.inbound_port.PandeBuddiesInboundPort;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryPandeBuddyRepository;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.shared_questionnaire.QuestionnaireHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddPandeBuddiesController {
    private PandeBuddiesInboundPort pandeBuddiesInboundPort;
    private InMemoryPandeBuddyRepository repository;

    @Autowired
    public AddPandeBuddiesController(FetchPandeBuddy pandeBuddy, InMemoryPandeBuddyRepository repository) {
        this.pandeBuddiesInboundPort = new PandeBuddiesUseCase(pandeBuddy);
        this.repository = repository;
    }

    public ResponseEntity<PandeBuddyJson> addPandeBuddy(UsernameJson requestUsername, String pandeName) {
        Username newBuddyUsername = Username.from(requestUsername.getUsername());
        Username username = Username.from(pandeName);
        JsonPandeBuddiesPresenter output = new JsonPandeBuddiesPresenter();

        pandeBuddiesInboundPort.invokeWith(newBuddyUsername, username, output);

        return output.getResponsePandeBuddy();
    }

    public void panikButtonPressedOn(String pandeName) {
        Username username = Username.from(pandeName);
        if (!repository.exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }

        PandeBuddy pandeBuddy = repository.withUsername(username).get();
        pandeBuddy.setPanikButtonFlag(true);
        pandeBuddy.getScore().setColor(QuestionnaireHelper.DANGER_COLOR);
        pandeBuddy.getScore().setValue(0);
        pandeBuddy.getScore().setNoMeet(true);
        pandeBuddy.getScore().setDaysLeftToMeet(QuestionnaireHelper.MAX_DAYS_LEFT_TO_MEET);

        repository.storePandeBuddy(pandeBuddy);
    }
}
