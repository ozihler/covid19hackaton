package com.zihler.covid19hackaton.adapters.presentation.controllers;

import com.zihler.covid19hackaton.adapters.presentation.presenters.RestWelcomeMessagePresenter;
import com.zihler.covid19hackaton.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import com.zihler.covid19hackaton.application.use_cases.view_welcome_message.ViewWelcomeMessageUseCase;
import com.zihler.covid19hackaton.application.use_cases.view_welcome_message.inbound_port.ViewWelcomeMessage;
import com.zihler.covid19hackaton.domain.values.EventName;
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
