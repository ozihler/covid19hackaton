package com.hackaton.covid19.register.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.UserJson;
import com.hackaton.covid19.register.application.documents.UserDocument;
import org.springframework.http.ResponseEntity;

public class CreatedUserOutput {

    private ResponseEntity<UserJson> response;

    public ResponseEntity<UserJson> response() {
        return response;
    }

    public void present(UserDocument userDocument) {
        response = ResponseEntity.ok(new UserJson(userDocument.getUsername().value()));
    }
}
