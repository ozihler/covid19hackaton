package com.hackaton.covid19.entryquestionnaire;

import java.util.List;
import java.util.Objects;

public class EntryQuestionnaire {
    private String gender;
    private String age;
    private boolean belongsToRiskCategory;
    private boolean hadSymptoms;
    private int numberOfPeopleInHousehold;
    private boolean livesWithPeopleOfRiskCategory;
    private int numberOfPeopleMetInTheLast2Weeks;
    private int daysSinceLastWentOut;
    private List<String> regularPreventiveMeasures;

    public EntryQuestionnaire() {
    }

    public EntryQuestionnaire(String gender, String age, boolean belongsToRiskCategory, boolean hadSymptoms, int numberOfPeopleInHousehold, boolean livesWithPeopleOfRiskCategory, int numberOfPeopleMetInTheLast2Weeks, int daysSinceLastWentOut, List<String> regularPreventiveMeasures) {
        this.gender = gender;
        this.age = age;
        this.belongsToRiskCategory = belongsToRiskCategory;
        this.hadSymptoms = hadSymptoms;
        this.numberOfPeopleInHousehold = numberOfPeopleInHousehold;
        this.livesWithPeopleOfRiskCategory = livesWithPeopleOfRiskCategory;
        this.numberOfPeopleMetInTheLast2Weeks = numberOfPeopleMetInTheLast2Weeks;
        this.daysSinceLastWentOut = daysSinceLastWentOut;
        this.regularPreventiveMeasures = regularPreventiveMeasures;
    }

    @Override
    public String toString() {
        return "EntryQuestionnaire{" +
                "gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", belongsToRiskCategory=" + belongsToRiskCategory +
                ", hadSymptoms=" + hadSymptoms +
                ", numberOfPeopleInHousehold=" + numberOfPeopleInHousehold +
                ", livesWithPeopleOfRiskCategory=" + livesWithPeopleOfRiskCategory +
                ", numberOfPeopleMetInTheLast2Weeks=" + numberOfPeopleMetInTheLast2Weeks +
                ", daysSinceLastWentOut=" + daysSinceLastWentOut +
                ", regularPreventiveMeasures=" + regularPreventiveMeasures +
                '}';
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
}
