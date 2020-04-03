package com.hackaton.covid19.welcome_message.application.use_cases.view_welcome_message.inbound_port;

 import com.hackaton.covid19.welcome_message.application.outbound_ports.presenters.WelcomeMessagePresenter;
 import com.hackaton.covid19.welcome_message.domain.values.EventName;

public interface ViewWelcomeMessage {
    void invokeWith(EventName name, WelcomeMessagePresenter output);
}
