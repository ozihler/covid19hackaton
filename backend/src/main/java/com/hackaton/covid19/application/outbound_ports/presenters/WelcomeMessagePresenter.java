package com.hackaton.covid19.application.outbound_ports.presenters;

import com.hackaton.covid19.domain.values.WelcomeMessage;

public interface WelcomeMessagePresenter {
    void present(WelcomeMessage welcomeMessage);
}
