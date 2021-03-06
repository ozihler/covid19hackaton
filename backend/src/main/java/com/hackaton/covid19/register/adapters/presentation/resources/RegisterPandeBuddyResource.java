package com.hackaton.covid19.register.adapters.presentation.resources;

import com.hackaton.covid19.register.adapters.presentation.controllers.RegisterPandeBuddyController;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.shared.adapters.presentation.viewmodels.UsernameJson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterPandeBuddyResource {

    private final RegisterPandeBuddyController registerPandeBuddyController;

    public RegisterPandeBuddyResource(RegisterPandeBuddyController registerPandeBuddyController) {
        this.registerPandeBuddyController = registerPandeBuddyController;
    }

    @PostMapping(
            path = "/register",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<PandeBuddyJson> register(@RequestBody UsernameJson requestUsername) {

        return registerPandeBuddyController.registerUserWith(requestUsername);

    }

}
