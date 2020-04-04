package com.hackaton.covid19.pandebuddies.adapters.presentation.controllers;

import com.hackaton.covid19.pandebuddies.adapters.presentation.presenters.JsonPandeBuddiesPresenter;
import com.hackaton.covid19.pandebuddies.application.use_cases.PandeBuddiesUseCase;
import com.hackaton.covid19.pandebuddies.application.use_cases.inbound_port.PandeBuddiesInboundPort;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.shared.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddPandeBuddiesController {
    private PandeBuddiesInboundPort pandeBuddiesInboundPort;

    @Autowired
    public AddPandeBuddiesController(FetchPandeBuddy pandeBuddy) {
        this.pandeBuddiesInboundPort = new PandeBuddiesUseCase(pandeBuddy);
    }

    public ResponseEntity<PandeBuddyJson> addPandeBuddy(UsernameJson requestUsername, String pandeName) {
        Username newBuddyUsername = Username.from(requestUsername.getUsername());
        Username username = Username.from(pandeName);
        JsonPandeBuddiesPresenter output = new JsonPandeBuddiesPresenter();

        pandeBuddiesInboundPort.invokeWith(newBuddyUsername, username, output);

        return output.getResponsePandeBuddy();
    }
}
