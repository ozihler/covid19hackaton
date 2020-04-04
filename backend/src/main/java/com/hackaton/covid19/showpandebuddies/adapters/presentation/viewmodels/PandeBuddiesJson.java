package com.hackaton.covid19.showpandebuddies.adapters.presentation.viewmodels;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;

import java.util.List;

public class PandeBuddiesJson {
    List<PandeBuddyJson> pandeBuddies;

    public PandeBuddiesJson(List<PandeBuddyJson> pandeBuddies) {
        this.pandeBuddies = pandeBuddies;
    }

    public PandeBuddiesJson() {
    }

    public List<PandeBuddyJson> getPandeBuddies() {
        return pandeBuddies;
    }
}
