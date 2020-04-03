package com.hackaton.covid19.register.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.UserJson;
import com.hackaton.covid19.register.application.outbound_ports.UserDocument;
import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.register.domain.values.Username;
import org.springframework.http.ResponseEntity;

public class RestCreatedUserPresenter implements CreatedUserPresenter {

    private ResponseEntity<UserJson> response;

    public ResponseEntity<UserJson> response() {
        return response;
    }

    @Override
    public void present(UserDocument userDocument) {
        Username username = userDocument.getUsername();
        String value = username.value();
        UserJson userJson = new UserJson(value);
        response = ResponseEntity.ok(userJson);
    }
}
