package com.hackaton.covid19.welcome_message.application.outbound_ports.presenters;

import com.hackaton.covid19.welcome_message.domain.values.WelcomeMessage;

public interface WelcomeMessagePresenter {
    void present(WelcomeMessage welcomeMessage);
}
