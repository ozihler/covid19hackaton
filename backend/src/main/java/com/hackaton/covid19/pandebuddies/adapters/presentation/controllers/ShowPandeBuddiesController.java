package com.hackaton.covid19.pandebuddies.adapters.presentation.controllers;

import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.pandebuddies.adapters.presentation.presenters.JsonPandeBuddiesPresenter;
import com.hackaton.covid19.pandebuddies.adapters.presentation.viewmodels.PandeBuddiesJson;
import com.hackaton.covid19.pandebuddies.application.use_cases.PandeBuddiesUseCase;
import com.hackaton.covid19.pandebuddies.application.use_cases.inbound_port.PandeBuddiesInboundPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ShowPandeBuddiesController {
    private PandeBuddiesInboundPort pandeBuddies;

    @Autowired
    public ShowPandeBuddiesController(FetchPandeBuddies fetchPandeBuddies) {
        this.pandeBuddies = new PandeBuddiesUseCase(fetchPandeBuddies);
    }

    public ResponseEntity<PandeBuddiesJson> showPandeBuddiesFor(String pandeName) {
        Username username = Username.from(pandeName);
        JsonPandeBuddiesPresenter output = new JsonPandeBuddiesPresenter();

        pandeBuddies.invokeWith(username, output);

        return output.getResponsePandeBuddies();
    }
}
