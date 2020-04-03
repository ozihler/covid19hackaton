package com.hackaton.covid19.register.adapters.presentation.controllers;

import com.hackaton.covid19.register.adapters.presentation.presenters.RestCreatedUserPresenter;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UserJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.register.application.use_cases.RegisterUserUseCase;
import com.hackaton.covid19.register.application.use_cases.inbound_port.RegisterUser;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchUser;
import com.hackaton.covid19.shared.application.outbound_ports.StoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserController {

    private RegisterUser registerUser;

    @Autowired
    public RegisterUserController(FetchUser fetchUser, StoreUser storeUser) {
        this.registerUser = new RegisterUserUseCase(fetchUser, storeUser);
    }

    public ResponseEntity<UserJson> registerUserWith(UsernameJson requestUsername) {
        var username = Username.from(requestUsername.getUsername());
        var output = new RestCreatedUserPresenter();

        this.registerUser.invokeWith(username, output);

        return output.response();
    }
}
