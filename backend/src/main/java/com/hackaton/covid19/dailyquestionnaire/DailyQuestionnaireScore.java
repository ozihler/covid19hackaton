package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared_questionnaire.QuestionnaireHelper;

import java.time.LocalDate;
import java.time.Period;

public class DailyQuestionnaireScore {

    private DailyQuestionnaire dailyQuestionnaire;

    public DailyQuestionnaireScore(DailyQuestionnaire dailyQuestionnaire) {
        this.dailyQuestionnaire = dailyQuestionnaire;
    }

    ScoreJson score() {
        ScoreJson scoreJson = new ScoreJson(0, QuestionnaireHelper.SAFE_COLOR, 0, false);
        calculateMeetInXDays(scoreJson);
        if(!scoreJson.isNoMeet()) {
            int value = calculateScore();
            scoreJson.setValue(value);
            scoreJson.setColor(new QuestionnaireHelper().getColor(value));
        }
        return scoreJson;
    }

    private void calculateMeetInXDays(ScoreJson scoreJson) {
        if (dailyQuestionnaire.isSymptoms()
                || dailyQuestionnaire.getTransportation().contains("Travel abroad")
                || dailyQuestionnaire.getMetInfectedPeople().contains("Infected people")
                || dailyQuestionnaire.getMetInfectedPeople().contains("People taking care of sick people")) {
            LocalDate now = LocalDate.now();
            LocalDate then = dailyQuestionnaire.getDate();
            int daysLeftToMeet = QuestionnaireHelper.MAX_DAYS_LEFT_TO_MEET;
            if(then != null){
               daysLeftToMeet = QuestionnaireHelper.MAX_DAYS_LEFT_TO_MEET - Period.between(now, then).getDays();
            }
            if(daysLeftToMeet > 0){
                scoreJson.setDaysLeftToMeet(daysLeftToMeet);
                scoreJson.setNoMeet(true);
                scoreJson.setColor(QuestionnaireHelper.DANGER_COLOR);
            }
        }
    }

    private int calculateScore() {
        int scoreValue = 0;

        if (!dailyQuestionnaire.isSymptoms()){
            scoreValue += 200;
        }

        for (String preventiveMeasure:dailyQuestionnaire.getPreventiveMeasuresPerformed()) {
            if ("Wash hands with soap or use desinfection".equalsIgnoreCase(preventiveMeasure)) {
                scoreValue += 200;
            }
            if ("Wear a mask when going out".equalsIgnoreCase(preventiveMeasure)){
                scoreValue += 100;
            }
            if ("Avoiding handshakes / kisses / hugs".equalsIgnoreCase(preventiveMeasure)){
                scoreValue += 200;
            }
            if ("Keep distance from other people".equalsIgnoreCase(preventiveMeasure)){
                scoreValue += 300;
            }
        }

        for (String placeVisited:dailyQuestionnaire.getPlacesVisited()){
            if("Stayed at home".equalsIgnoreCase(placeVisited)){
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

        if(dailyQuestionnaire.getPeopleMet() == 0){
            scoreValue += 200;
        } else {
            scoreValue -= 100*dailyQuestionnaire.getPeopleMet();
        }

        for (String infectedPeople : dailyQuestionnaire.getMetInfectedPeople()){
            if ("Risk categories".equalsIgnoreCase(infectedPeople)){
                scoreValue -= 500;
            }
        }

        return scoreValue;
    }
}
