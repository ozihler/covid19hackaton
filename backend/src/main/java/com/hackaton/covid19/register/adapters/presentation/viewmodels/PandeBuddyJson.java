package com.hackaton.covid19.register.adapters.presentation.viewmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaire;

import java.util.List;

public class PandeBuddyJson {
    @JsonProperty("pandeName")
    private String username;

    private List<PandeBuddyJson> pandeBuddies;
    private String imageUrl;
    private ScoreJson score = new ScoreJson();
    private EntryQuestionnaire entryQuestionnaire;


    public PandeBuddyJson() {
    }

    public PandeBuddyJson(String username, List<PandeBuddyJson> pandeBuddies, String imageUrl, ScoreJson score) {
        this.username = username;
        this.pandeBuddies = pandeBuddies;
        this.imageUrl = imageUrl;
        this.score = score;
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

    public void setEntryQuestionnaire(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }
}
