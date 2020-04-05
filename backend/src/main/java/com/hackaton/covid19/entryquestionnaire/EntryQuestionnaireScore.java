package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared_questionnaire.QuestionnaireHelper;
import org.apache.logging.log4j.util.Strings;

import java.time.LocalDate;
import java.time.Period;

public class EntryQuestionnaireScore {

    private EntryQuestionnaire entryQuestionnaire;

    public EntryQuestionnaireScore(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }

    ScoreJson score() {
        if (!shouldMeetEver()) {
            ScoreJson scoreJson = new ScoreJson();
            scoreJson.setDaysLeftToMeet(QuestionnaireHelper.NO_MEET_EVER_IDENTIFICATION_NUMBER);
            scoreJson.setNoMeet(true);
            scoreJson.setValue(0);
            scoreJson.setColor(QuestionnaireHelper.DANGER_COLOR);
            return scoreJson;
        } else if (!shouldMeetBefore2WeeksPassed() && daysLeftToMeet() != 1) {
            ScoreJson scoreJson = new ScoreJson();
            scoreJson.setDaysLeftToMeet(daysLeftToMeet());
            scoreJson.setNoMeet(true);
            scoreJson.setValue(0);
            scoreJson.setColor(QuestionnaireHelper.DANGER_COLOR);
            return scoreJson;
        } else {
            ScoreJson scoreJson = new ScoreJson();
            scoreJson.setNoMeet(false);
            scoreJson.setDaysLeftToMeet(0);
            int value = calculateScore();
            scoreJson.setValue(value);
            scoreJson.setColor(new QuestionnaireHelper().getColor(value));
            return scoreJson;
        }
    }

    private int daysLeftToMeet() {
        LocalDate now = LocalDate.now();
        LocalDate then = entryQuestionnaire.getDate();
        int daysLeftToMeet = QuestionnaireHelper.MAX_DAYS_LEFT_TO_MEET;
        if(then != null){
            daysLeftToMeet = QuestionnaireHelper.MAX_DAYS_LEFT_TO_MEET - Period.between(now, then).getDays();
        }
        return Math.max(daysLeftToMeet, 1);
    }

    private boolean shouldMeetEver() {
        return entryQuestionnaire.getAge() <= QuestionnaireHelper.HIGH_RISK_AGE
                && !entryQuestionnaire.isBelongsToRiskCategory()
                && !entryQuestionnaire.isLivesWithPeopleOfRiskCategory();

    }

    private boolean shouldMeetBefore2WeeksPassed() {
        return !entryQuestionnaire.isHadSymptoms()
                && !entryQuestionnaire.isHasTraveledAbroad()
                && !entryQuestionnaire.isHasMetInfectedPeopleInTheLast2Weeks();
    }

    private int calculateScore() {
        int scoreValue = 0;

        if (!entryQuestionnaire.isBelongsToRiskCategory()) {
            scoreValue += 200;
        }

        if (!entryQuestionnaire.isHasTraveledAbroad()) {
            scoreValue += 200;
        }

        if (entryQuestionnaire.getNumberOfPeopleInHousehold() <= 1) {
            scoreValue += 200;
        } else {
            scoreValue -= (entryQuestionnaire.getNumberOfPeopleInHousehold() * 100);
        }

        if (!entryQuestionnaire.isLivesWithPeopleOfRiskCategory()) {
            scoreValue += 200;
        }


        scoreValue -= entryQuestionnaire.getNumberOfPeopleMetInTheLast2Weeks() * 100;

        if (!entryQuestionnaire.isHasMetInfectedPeopleInTheLast2Weeks()) {
            scoreValue += 200;
        }

        scoreValue += entryQuestionnaire.getDaysSinceLastWentOut() * 50;

        scoreValue += entryQuestionnaire.getRegularPreventiveMeasures()
                .stream()
                .map(String::trim)
                .filter(Strings::isNotEmpty)
                .filter(a -> a.equalsIgnoreCase("Wash hands with soap or use desinfection gel")
                        || a.equalsIgnoreCase("Avoiding handshakes / kisses / hugs"))
                .count() * 200;

        scoreValue += entryQuestionnaire.getRegularPreventiveMeasures()
                .stream()
                .map(String::trim)
                .filter(Strings::isNotEmpty)
                .filter(a -> a.equalsIgnoreCase("Wear a mask when going out"))
                .count() * 100;

        scoreValue += entryQuestionnaire.getRegularPreventiveMeasures()
                .stream()
                .map(String::trim)
                .filter(Strings::isNotEmpty)
                .filter(a -> a.equalsIgnoreCase("Keep distance from other people"))
                .count() * 300;

        return scoreValue;
    }
}
