package com.zihler.covid19hackaton.application.use_cases.view_welcome_message;

import com.zihler.covid19hackaton.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.zihler.covid19hackaton.application.use_cases.view_welcome_message.inbound_port.ViewWelcomeMessage;
import com.zihler.covid19hackaton.domain.values.EventName;
import com.zihler.covid19hackaton.domain.values.WelcomeMessage;

public class ViewWelcomeMessageUseCase implements ViewWelcomeMessage {
    @Override
    public void invokeWith(EventName name, WelcomeMessagePresenter output) {
        var welcomeMessage = WelcomeMessage.with(name);

        output.present(welcomeMessage);
    }
}
