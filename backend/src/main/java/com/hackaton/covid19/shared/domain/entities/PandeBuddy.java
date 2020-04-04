package com.hackaton.covid19.shared.domain.entities;

import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;

public class PandeBuddy {

    private Username username;
    private PandeBuddies pandeBuddies;

    public PandeBuddy(Username username, PandeBuddies pandeBuddies) {
        this.username = username;
        this.pandeBuddies = pandeBuddies;
    }

    public Username getUsername() {
        return username;
    }

    public PandeBuddies getPandeBuddies() {
        return pandeBuddies;
    }

}
