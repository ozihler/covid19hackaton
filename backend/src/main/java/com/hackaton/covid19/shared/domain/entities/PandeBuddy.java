package com.hackaton.covid19.shared.domain.entities;

import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;

public class PandeBuddy {

    private Username username;
    private PandeBuddies pandeBuddies;
    private String imageUrl;
    private Score score = new Score();

    public PandeBuddy(Username username, PandeBuddies pandeBuddies, String imageUrl, Score score) {
        this.username = username;
        this.pandeBuddies = pandeBuddies;
        this.imageUrl = imageUrl;
        this.score = score;
    }
    public PandeBuddy(Username username, PandeBuddies pandeBuddies, String imageUrl) {
        this(username, pandeBuddies, imageUrl, new Score());
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

}
