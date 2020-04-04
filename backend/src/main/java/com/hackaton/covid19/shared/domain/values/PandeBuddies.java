package com.hackaton.covid19.shared.domain.values;

import com.hackaton.covid19.shared.domain.entities.PandeBuddy;

import java.util.List;

public class PandeBuddies {
    List<PandeBuddy> pandeBuddies;

    public PandeBuddies(List<PandeBuddy> pandeBuddies) {
        this.pandeBuddies = pandeBuddies;
    }

    public List<PandeBuddy> getPandeBuddies() {
        return pandeBuddies;
    }
}
