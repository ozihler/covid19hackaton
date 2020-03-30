package com.hackaton.covid19.application.use_cases.view_welcome_message;

import com.hackaton.covid19.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.hackaton.covid19.application.use_cases.view_welcome_message.inbound_port.ViewWelcomeMessage;
import com.hackaton.covid19.domain.values.EventName;
import com.hackaton.covid19.domain.values.WelcomeMessage;

public class ViewWelcomeMessageUseCase implements ViewWelcomeMessage {
    @Override
    public void invokeWith(EventName name, WelcomeMessagePresenter output) {
        var welcomeMessage = WelcomeMessage.with(name);

        output.present(welcomeMessage);
    }
}
