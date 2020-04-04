package com.hackaton.covid19.register.adapters.presentation.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PandeBuddyJson {
    @JsonProperty("pandeName")
    private String username;

    private List<PandeBuddyJson> pandeBuddies;
    private String imageUrl;
    private ScoreJson score = new ScoreJson();


    public PandeBuddyJson() {
    }

    public PandeBuddyJson(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PandeBuddyJson> getPandeBuddies() {
        return pandeBuddies;
    }

    public void setPandeBuddies(List<PandeBuddyJson> pandeBuddies) {
        this.pandeBuddies = pandeBuddies;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ScoreJson getScore() {
        return score;
    }

    public void setScore(ScoreJson score) {
        this.score = score;
    }
}
