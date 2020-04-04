package com.hackaton.covid19.register.adapters.presentation.viewmodels;

public class ScoreJson {
    private int value;
    private String color;
    private int daysLeftToMeet;

    public ScoreJson() {
    }

    public ScoreJson(int value, String color, int daysLeftToMeet) {
        this.value = value;
        this.color = color;
        this.daysLeftToMeet = daysLeftToMeet;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDaysLeftToMeet() {
        return daysLeftToMeet;
    }

    public void setDaysLeftToMeet(int daysLeftToMeet) {
        this.daysLeftToMeet = daysLeftToMeet;
    }
}
