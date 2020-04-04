package com.hackaton.covid19.dailyquestionnaire;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DailyQuestionnaire {

    private LocalDate date;
    private boolean symptoms;
    private List<String> preventiveMeasuresPerformed;
    private List<String> placesVisited;
    private List<String> transportation;
    private int peopleMet;
    private List<String> metInfectedPeople;


    public DailyQuestionnaire(boolean symptoms, List<String> preventiveMeasuresPerformed, List<String> placesVisited, List<String> transportation, int peopleMet, List<String> metInfectedPeople) {
        this.date = LocalDate.now();
        this.symptoms = symptoms;
        this.preventiveMeasuresPerformed = preventiveMeasuresPerformed;
        this.placesVisited = placesVisited;
        this.transportation = transportation;
        this.peopleMet = peopleMet;
        this.metInfectedPeople = metInfectedPeople;
    }

    public DailyQuestionnaire(){}

    public LocalDate getDate() {
        return date;
    }

    public boolean isSymptoms() {
        return symptoms;
    }

    public void setSymptoms(boolean symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getPreventiveMeasuresPerformed() {
        return preventiveMeasuresPerformed;
    }

    public void setPreventiveMeasuresPerformed(List<String> preventiveMeasuresPerformed) {
        this.preventiveMeasuresPerformed = preventiveMeasuresPerformed;
    }

    public List<String> getPlacesVisited() {
        return placesVisited;
    }

    public void setPlacesVisited(List<String> placesVisited) {
        this.placesVisited = placesVisited;
    }

    public List<String> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<String> transportation) {
        this.transportation = transportation;
    }

    public int getPeopleMet() {
        return peopleMet;
    }

    public void setPeopleMet(int peopleMet) {
        this.peopleMet = peopleMet;
    }

    public List<String> getMetInfectedPeople() {
        return metInfectedPeople;
    }

    public void setMetInfectedPeople(List<String> metInfectedPeople) {
        this.metInfectedPeople = metInfectedPeople;
    }

    @Override
    public String toString() {
        return "DailyQuestionnaire{" +
                "symptoms=" + symptoms +
                ", preventiveMeasuresPerformed=" + preventiveMeasuresPerformed +
                ", placesVisited=" + placesVisited +
                ", transportation=" + transportation +
                ", peopleMet=" + peopleMet +
                ", metInfectedPeople=" + metInfectedPeople +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyQuestionnaire that = (DailyQuestionnaire) o;
        return symptoms == that.symptoms &&
                peopleMet == that.peopleMet &&
                Objects.equals(preventiveMeasuresPerformed, that.preventiveMeasuresPerformed) &&
                Objects.equals(placesVisited, that.placesVisited) &&
                Objects.equals(transportation, that.transportation) &&
                Objects.equals(metInfectedPeople, that.metInfectedPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symptoms, preventiveMeasuresPerformed, placesVisited, transportation, peopleMet, metInfectedPeople);
    }
}
