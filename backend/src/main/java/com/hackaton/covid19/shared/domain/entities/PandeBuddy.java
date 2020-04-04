package com.hackaton.covid19.shared.domain.entities;

import com.hackaton.covid19.dailyquestionnaire.DailyQuestionnaire;
import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaire;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;

import java.util.ArrayList;
import java.util.List;

public class PandeBuddy {

    private Username username;
    private PandeBuddies pandeBuddies;
    private String imageUrl;
    private Score score = new Score();
    private EntryQuestionnaire entryQuestionnaire;
    private List<DailyQuestionnaire> dailyQuestionnaires;

    public PandeBuddy(Username username, PandeBuddies pandeBuddies, String imageUrl, Score score) {
        this.username = username;
        this.pandeBuddies = pandeBuddies;
        this.imageUrl = imageUrl;
        this.score = score;
        this.dailyQuestionnaires = new ArrayList<>();
    }

    public PandeBuddy() {
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public void setPandeBuddies(PandeBuddies pandeBuddies) {
        this.pandeBuddies = pandeBuddies;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Score getScore() {
        return score;
    }

    public Username getUsername() {
        return username;
    }

    public PandeBuddies getPandeBuddies() {
        return pandeBuddies;
    }


    public EntryQuestionnaire getEntryQuestionnaire() {
        return entryQuestionnaire;
    }

    public void setEntryQuestionnaire(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }

    public List<DailyQuestionnaire> getDailyQuestionnaires() {
        return dailyQuestionnaires;
    }
}
