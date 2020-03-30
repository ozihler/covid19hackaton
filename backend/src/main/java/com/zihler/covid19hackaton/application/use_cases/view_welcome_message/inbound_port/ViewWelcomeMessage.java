package com.zihler.covid19hackaton.application.use_cases.view_welcome_message.inbound_port;

 import com.zihler.covid19hackaton.application.outbound_ports.presenters.WelcomeMessagePresenter;
 import com.zihler.covid19hackaton.domain.values.EventName;

public interface ViewWelcomeMessage {
    void invokeWith(EventName name, WelcomeMessagePresenter output);
}
