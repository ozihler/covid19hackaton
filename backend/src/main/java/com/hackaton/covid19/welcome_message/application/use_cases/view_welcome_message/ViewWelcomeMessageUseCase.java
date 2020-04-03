package com.hackaton.covid19.welcome_message.application.use_cases.view_welcome_message;

import com.hackaton.covid19.welcome_message.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.hackaton.covid19.welcome_message.application.use_cases.view_welcome_message.inbound_port.ViewWelcomeMessage;
import com.hackaton.covid19.welcome_message.domain.values.EventName;
import com.hackaton.covid19.welcome_message.domain.values.WelcomeMessage;

public class ViewWelcomeMessageUseCase implements ViewWelcomeMessage {
    @Override
    public void invokeWith(EventName name, WelcomeMessagePresenter output) {
        var welcomeMessage = WelcomeMessage.with(name);

        output.present(welcomeMessage);
    }
}
