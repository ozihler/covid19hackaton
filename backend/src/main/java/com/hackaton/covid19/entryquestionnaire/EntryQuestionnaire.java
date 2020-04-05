package com.hackaton.covid19.entryquestionnaire;

import java.time.LocalDate;
import java.util.List;

public class EntryQuestionnaire {
    private LocalDate date;
    private String gender;
    private int age;
    private boolean belongsToRiskCategory;
    private boolean hadSymptoms;
    private boolean hasTraveledAbroad;
    private int numberOfPeopleInHousehold;
    private boolean livesWithPeopleOfRiskCategory;
    private int numberOfPeopleMetInTheLast2Weeks;
    private boolean hasMetInfectedPeopleInTheLast2Weeks;
    private int daysSinceLastWentOut;
    private List<String> regularPreventiveMeasures;

    public EntryQuestionnaire() {
    }

    public EntryQuestionnaire(String gender, int age,
                              boolean belongsToRiskCategory,
                              boolean hadSymptoms,
                              boolean hasTraveledAbroad,
                              int numberOfPeopleInHousehold,
                              boolean livesWithPeopleOfRiskCategory,
                              int numberOfPeopleMetInTheLast2Weeks,
                              boolean hasMetInfectedPeopleInTheLast2Weeks,
                              int daysSinceLastWentOut,
                              List<String> regularPreventiveMeasures) {
        this.date = LocalDate.now();
        this.gender = gender;
        this.age = age;
        this.belongsToRiskCategory = belongsToRiskCategory;
        this.hadSymptoms = hadSymptoms;
        this.hasTraveledAbroad = hasTraveledAbroad;
        this.numberOfPeopleInHousehold = numberOfPeopleInHousehold;
        this.livesWithPeopleOfRiskCategory = livesWithPeopleOfRiskCategory;
        this.numberOfPeopleMetInTheLast2Weeks = numberOfPeopleMetInTheLast2Weeks;
        this.hasMetInfectedPeopleInTheLast2Weeks = hasMetInfectedPeopleInTheLast2Weeks;
        this.daysSinceLastWentOut = daysSinceLastWentOut;
        this.regularPreventiveMeasures = regularPreventiveMeasures;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isHasMetInfectedPeopleInTheLast2Weeks() {
        return hasMetInfectedPeopleInTheLast2Weeks;
    }

    @Override
    public String toString() {
        return "EntryQuestionnaire{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", belongsToRiskCategory=" + belongsToRiskCategory +
                ", hadSymptoms=" + hadSymptoms +
                ", hasTraveledAbroad=" + hasTraveledAbroad +
                ", numberOfPeopleInHousehold=" + numberOfPeopleInHousehold +
                ", livesWithPeopleOfRiskCategory=" + livesWithPeopleOfRiskCategory +
                ", numberOfPeopleMetInTheLast2Weeks=" + numberOfPeopleMetInTheLast2Weeks +
                ", hasMetInfectedPeopleInTheLast2Weeks=" + hasMetInfectedPeopleInTheLast2Weeks +
                ", daysSinceLastWentOut=" + daysSinceLastWentOut +
                ", regularPreventiveMeasures=" + regularPreventiveMeasures +
                '}';
    }

    public void setHasMetInfectedPeopleInTheLast2Weeks(boolean hasMetInfectedPeopleInTheLast2Weeks) {
        this.hasMetInfectedPeopleInTheLast2Weeks = hasMetInfectedPeopleInTheLast2Weeks;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBelongsToRiskCategory() {
        return belongsToRiskCategory;
    }

    public void setBelongsToRiskCategory(boolean belongsToRiskCategory) {
        this.belongsToRiskCategory = belongsToRiskCategory;
    }

    public boolean isHadSymptoms() {
        return hadSymptoms;
    }

    public void setHadSymptoms(boolean hadSymptoms) {
        this.hadSymptoms = hadSymptoms;
    }

    public int getNumberOfPeopleInHousehold() {
        return numberOfPeopleInHousehold;
    }

    public void setNumberOfPeopleInHousehold(int numberOfPeopleInHousehold) {
        this.numberOfPeopleInHousehold = numberOfPeopleInHousehold;
    }

    public boolean isLivesWithPeopleOfRiskCategory() {
        return livesWithPeopleOfRiskCategory;
    }

    public void setLivesWithPeopleOfRiskCategory(boolean livesWithPeopleOfRiskCategory) {
        this.livesWithPeopleOfRiskCategory = livesWithPeopleOfRiskCategory;
    }

    public int getNumberOfPeopleMetInTheLast2Weeks() {
        return numberOfPeopleMetInTheLast2Weeks;
    }

    public void setNumberOfPeopleMetInTheLast2Weeks(int numberOfPeopleMetInTheLast2Weeks) {
        this.numberOfPeopleMetInTheLast2Weeks = numberOfPeopleMetInTheLast2Weeks;
    }

    public int getDaysSinceLastWentOut() {
        return daysSinceLastWentOut;
    }

    public void setDaysSinceLastWentOut(int daysSinceLastWentOut) {
        this.daysSinceLastWentOut = daysSinceLastWentOut;
    }

    public List<String> getRegularPreventiveMeasures() {
        return regularPreventiveMeasures;
    }

    public void setRegularPreventiveMeasures(List<String> regularPreventiveMeasures) {
        this.regularPreventiveMeasures = regularPreventiveMeasures;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasTraveledAbroad() {
        return hasTraveledAbroad;
    }

    public void setHasTraveledAbroad(boolean hasTraveledAbroad) {
        this.hasTraveledAbroad = hasTraveledAbroad;
    }
}
