package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;

import java.time.LocalDate;
import java.time.Period;

public class DailyQuestionnaireScore {

    public static final int MAX_DAYS_LEFT_TO_MEET = 14;
    public static final String DANGER_COLOR = "red";


    private DailyQuestionnaire dailyQuestionnaire;

    public DailyQuestionnaireScore(DailyQuestionnaire dailyQuestionnaire) {
        this.dailyQuestionnaire = dailyQuestionnaire;
    }

    ScoreJson score() {
        ScoreJson scoreJson = new ScoreJson(0, "COLOR", 1, false);
        calculateMeetInXDays(scoreJson);
        if(scoreJson.isNoMeet()) {
            scoreJson.setValue(calculateScore());
        }
        return scoreJson;
    }

    private void calculateMeetInXDays(ScoreJson scoreJson) {
        if (dailyQuestionnaire.isSymptoms()
                || "Travel abroad".equals(dailyQuestionnaire.getTransportation())
                || "Infected people".equals(dailyQuestionnaire.getMetInfectedPeople())
                || "Take care of sick people".equals(dailyQuestionnaire.getMetInfectedPeople())) {
            LocalDate now = LocalDate.now();
            LocalDate then = dailyQuestionnaire.getDate();
            int daysLeftToMeet = MAX_DAYS_LEFT_TO_MEET - Period.between(now, then).getDays();
            if(daysLeftToMeet > 1){
                scoreJson.setDaysLeftToMeet(daysLeftToMeet);
                scoreJson.setNoMeet(true);
                scoreJson.setColor(DANGER_COLOR);
            }
        }
    }

    private int calculateScore() {
        int scoreValue = 0;

        for (String preventiveMeasure:dailyQuestionnaire.getPreventiveMeasuresPerformed()) {
            if ("Wash hands with soap / use desinfection".equalsIgnoreCase(preventiveMeasure)) {
                scoreValue += 200;
            }
            if ("Wear a mask".equalsIgnoreCase(preventiveMeasure)){
                scoreValue += 100;
            }
            if ("Shake hands / hug / kiss".equalsIgnoreCase(preventiveMeasure)){
                scoreValue -= 200;
            }
            if ("Keep distance from other people".equalsIgnoreCase(preventiveMeasure)){
                scoreValue += 300;
            }
        }

        for (String placeVisited:dailyQuestionnaire.getPlacesVisited()){
            if("Stay at home".equalsIgnoreCase(placeVisited)){
                scoreValue += 300;
            }
            if ("Low risk places".equalsIgnoreCase(placeVisited)){
                scoreValue -= 200;
            }
            if ("Middle risk places".equalsIgnoreCase(placeVisited)){
                scoreValue -= 400;
            }
            if ("High risk places".equalsIgnoreCase(placeVisited)){
                scoreValue -= 600;
            }
            if ("Online shopping & food delivery".equalsIgnoreCase(placeVisited)){
                scoreValue += 200;
            }
        }

        for (String transport: dailyQuestionnaire.getTransportation()){
            if ("Low risk transportation".equalsIgnoreCase(transport)){
                scoreValue += 300;
            }
            if ("Middle risk transportation".equalsIgnoreCase(transport)){
                scoreValue -= 100;
            }
            if ("High risk transportation".equalsIgnoreCase(transport)){
                scoreValue -= 200;
            }
        }

        scoreValue -= 100*dailyQuestionnaire.getPeopleMet();

        for (String infectedPeople : dailyQuestionnaire.getMetInfectedPeople()){
            if ("Risk categories".equalsIgnoreCase(infectedPeople)){
                scoreValue -= 500;
            }
        }

        return scoreValue;
    }
}
