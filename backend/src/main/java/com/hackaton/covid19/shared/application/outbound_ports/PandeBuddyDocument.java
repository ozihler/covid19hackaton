package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaire;
import com.hackaton.covid19.pandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;

public class PandeBuddyDocument {

    private Username username;
    private PandeBuddiesDocument pandeBuddies;
    private String imageUrl;
    private Score score;
    private EntryQuestionnaire entryQuestionnaire;

    public PandeBuddyDocument() {
    }


    public PandeBuddyDocument(Username username, PandeBuddiesDocument pandeBuddies, String imageUrl, Score score) {
        this.username = username;
        this.pandeBuddies = pandeBuddies;
        this.imageUrl = imageUrl;
        this.score = score;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public PandeBuddiesDocument getPandeBuddies() {
        return pandeBuddies;
    }

    public void setPandeBuddies(PandeBuddiesDocument pandeBuddies) {
        this.pandeBuddies = pandeBuddies;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setEntryQuestionnaire(EntryQuestionnaire entryQuestionnaire) {

        this.entryQuestionnaire = entryQuestionnaire;
    }

    public EntryQuestionnaire getEntryQuestionnaire() {
        return entryQuestionnaire;
    }
}
