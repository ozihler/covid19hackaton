package com.hackaton.covid19.shared.domain.values;

public class Score {
    private int value;
    private String color;
    private int daysLeftToMeet;

    public Score() {
    }

    public Score(int value, String color, int daysLeftToMeet) {
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
