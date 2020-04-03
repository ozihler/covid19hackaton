package com.hackaton.covid19.register.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.UserJson;
import com.hackaton.covid19.register.application.documents.UserDocument;
import com.hackaton.covid19.register.application.outbound_ports.CreatedUserOutput;
import com.hackaton.covid19.register.domain.values.Username;
import org.springframework.http.ResponseEntity;

public class RestCreatedUserOutput implements CreatedUserOutput {

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
