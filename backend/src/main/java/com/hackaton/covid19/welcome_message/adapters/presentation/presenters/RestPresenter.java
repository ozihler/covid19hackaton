package com.hackaton.covid19.welcome_message.adapters.presentation.presenters;

import org.springframework.http.ResponseEntity;

public abstract class RestPresenter<T> {
    protected ResponseEntity<T> response;

    public ResponseEntity<T> response() {
        return response;
    }

}
