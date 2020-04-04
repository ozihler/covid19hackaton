package com.hackaton.covid19.register.adapters.presentation.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PandeBuddyJson {
    @JsonProperty("pandeName")
    private String username;

    public PandeBuddyJson() {
    }

    public PandeBuddyJson(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
