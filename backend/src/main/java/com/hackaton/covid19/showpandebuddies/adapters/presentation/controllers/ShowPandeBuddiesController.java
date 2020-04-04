package com.hackaton.covid19.showpandebuddies.adapters.presentation.controllers;

import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.showpandebuddies.adapters.presentation.presenters.JsonShowPandeBuddiesPresenter;
import com.hackaton.covid19.showpandebuddies.adapters.presentation.viewmodels.PandeBuddiesJson;
import com.hackaton.covid19.showpandebuddies.application.use_cases.ShowPandeBuddiesUseCase;
import com.hackaton.covid19.showpandebuddies.application.use_cases.inbound_port.ShowPandeBuddies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ShowPandeBuddiesController {
    private ShowPandeBuddies showPandeBuddies;

    @Autowired
    public ShowPandeBuddiesController(FetchPandeBuddies fetchPandeBuddies) {
        this.showPandeBuddies = new ShowPandeBuddiesUseCase(fetchPandeBuddies);
    }

    public ResponseEntity<PandeBuddiesJson> showPandeBuddiesFor(String pandeName) {
        Username username = Username.from(pandeName);
        JsonShowPandeBuddiesPresenter output = new JsonShowPandeBuddiesPresenter();

        showPandeBuddies.invokeWith(username, output);

        return output.getResponse();
    }
}
