package com.zihler.covid19hackaton.application.outbound_ports.presenters;

import com.zihler.covid19hackaton.domain.values.WelcomeMessage;

public interface WelcomeMessagePresenter {
    void present(WelcomeMessage welcomeMessage);
}
