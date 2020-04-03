package com.hackaton.covid19.welcome_message.domain.values;

public class WelcomeMessage {
    private EventName name;

    private WelcomeMessage(EventName name) {
        this.name = name;
    }

    public static WelcomeMessage with(EventName name) {
        return new WelcomeMessage(name);
    }

    @Override
    public String toString() {
        return "Welcome to " + name.value();
    }
}
