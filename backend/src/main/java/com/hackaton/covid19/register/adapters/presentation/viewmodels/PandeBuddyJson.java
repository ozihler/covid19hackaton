package com.hackaton.covid19.register.adapters.presentation.viewmodels;

import java.util.ArrayList;
import java.util.List;

public class PandeBuddyJson {
    private String username;
    private List<PandeBuddyJson> pandeBuddies = new ArrayList<>();

    public PandeBuddyJson() {
    }

    public PandeBuddyJson(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
