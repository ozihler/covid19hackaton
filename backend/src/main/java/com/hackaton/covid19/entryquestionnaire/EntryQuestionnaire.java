package com.hackaton.covid19.entryquestionnaire;

import java.util.List;

public class EntryQuestionnaire {
    private String gender;
    private String age;
    private List<String> riskCategories;
    private List<String> symptoms;
    private boolean travelledAbroad;
    private boolean livesWithPeopleInSameHousehold;
    private boolean metInfectedPeople;
    private int daysNotOut;
    private List<String> preventiveMeasuresPerformed;

    public EntryQuestionnaire(String gender, String age, List<String> riskCategories, List<String> symptoms, boolean travelledAbroad, boolean livesWithPeopleInSameHousehold, boolean metInfectedPeople, int daysNotOut, List<String> preventiveMeasuresPerformed) {
        this.gender = gender;
        this.age = age;
        this.riskCategories = riskCategories;
        this.symptoms = symptoms;
        this.travelledAbroad = travelledAbroad;
        this.livesWithPeopleInSameHousehold = livesWithPeopleInSameHousehold;
        this.metInfectedPeople = metInfectedPeople;
        this.daysNotOut = daysNotOut;
        this.preventiveMeasuresPerformed = preventiveMeasuresPerformed;
    }

    public EntryQuestionnaire() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getRiskCategories() {
        return riskCategories;
    }

    public void setRiskCategories(List<String> riskCategories) {
        this.riskCategories = riskCategories;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isTravelledAbroad() {
        return travelledAbroad;
    }

    public void setTravelledAbroad(boolean travelledAbroad) {
        this.travelledAbroad = travelledAbroad;
    }

    public boolean isLivesWithPeopleInSameHousehold() {
        return livesWithPeopleInSameHousehold;
    }

    public void setLivesWithPeopleInSameHousehold(boolean livesWithPeopleInSameHousehold) {
        this.livesWithPeopleInSameHousehold = livesWithPeopleInSameHousehold;
    }

    public boolean isMetInfectedPeople() {
        return metInfectedPeople;
    }

    public void setMetInfectedPeople(boolean metInfectedPeople) {
        this.metInfectedPeople = metInfectedPeople;
    }

    public int getDaysNotOut() {
        return daysNotOut;
    }

    public void setDaysNotOut(int daysNotOut) {
        this.daysNotOut = daysNotOut;
    }

    public List<String> getPreventiveMeasuresPerformed() {
        return preventiveMeasuresPerformed;
    }

    public void setPreventiveMeasuresPerformed(List<String> preventiveMeasuresPerformed) {
        this.preventiveMeasuresPerformed = preventiveMeasuresPerformed;
    }
}
