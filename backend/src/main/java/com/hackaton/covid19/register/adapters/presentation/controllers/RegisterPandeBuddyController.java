package com.hackaton.covid19.register.adapters.presentation.controllers;

import com.hackaton.covid19.register.adapters.presentation.presenters.RestCreatedUserPresenter;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.register.application.use_cases.RegisterPandeBuddyUseCase;
import com.hackaton.covid19.register.application.use_cases.inbound_port.RegisterPandeBuddy;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterPandeBuddyController {

    private RegisterPandeBuddy registerPandeBuddy;

    @Autowired
    public RegisterPandeBuddyController(FetchPandeBuddy fetchPandeBuddy, StorePandeBuddy storePandeBuddy) {
        this.registerPandeBuddy = new RegisterPandeBuddyUseCase(fetchPandeBuddy, storePandeBuddy);
    }

    public ResponseEntity<PandeBuddyJson> registerUserWith(UsernameJson requestUsername) {
        var username = Username.from(requestUsername.getUsername());
        var output = new RestCreatedUserPresenter();

        this.registerPandeBuddy.invokeWith(username, output);

        return output.response();
    }
}
