package com.hackaton.covid19.updatescore;

public class Question {
    private String id;
    private String questionText;
    private int points;
    private String iconName;

    public Question(String id, String questionText, int points, String iconName) {
        this.id = id;
        this.questionText = questionText;
        this.points = points;
        this.iconName = iconName;
    }

    public String getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getPoints() {
        return points;
    }

    public String getIconName() {
        return iconName;
    }
}
