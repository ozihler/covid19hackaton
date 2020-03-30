package com.zihler.covid19hackaton.domain.values;

public class EventName {
    private String eventName;

    public EventName(String eventName){
        this.eventName = eventName;
    }

    public static EventName from(String eventName) {
        return new EventName(eventName);
    }

    public String value() {
        return eventName;
    }
}
