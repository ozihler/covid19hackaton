package com.hackaton.covid19.welcome_message.adapters.presentation.controllers;

import com.hackaton.covid19.welcome_message.adapters.presentation.presenters.RestWelcomeMessagePresenter;
import com.hackaton.covid19.welcome_message.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import com.hackaton.covid19.welcome_message.application.use_cases.view_welcome_message.ViewWelcomeMessageUseCase;
import com.hackaton.covid19.welcome_message.application.use_cases.view_welcome_message.inbound_port.ViewWelcomeMessage;
import com.hackaton.covid19.welcome_message.domain.values.EventName;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessageController {
    private ViewWelcomeMessage viewWelcomeMessage;

    public WelcomeMessageController() {
        this.viewWelcomeMessage = new ViewWelcomeMessageUseCase();
    }

    public ResponseEntity<WelcomeMessageViewModel> viewWelcomeMessage(String eventName) {
        EventName name = EventName.from(eventName);

        RestWelcomeMessagePresenter output = new RestWelcomeMessagePresenter();

        viewWelcomeMessage.invokeWith(name, output);

        return output.response();
    }
}
