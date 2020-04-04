package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import org.apache.logging.log4j.util.Strings;

public class EntryQuestionnaireScore {
    public static final int NO_MEET_EVER_IDENTIFICATION_NUMBER = -1;
    public static final int HIGH_RISK_AGE = 65;
    public static final int MAX_DAYS_LEFT_TO_MEET = 14;

    private EntryQuestionnaire entryQuestionnaire;

    public EntryQuestionnaireScore(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }

    ScoreJson score() {
        ScoreJson scoreJson = new ScoreJson();

        calculateNoMeetEver(scoreJson);
        calculateMeetIn2Weeks(scoreJson);
        scoreJson.setValue(calculateScore());

        return scoreJson;
    }

    private void calculateNoMeetEver(ScoreJson scoreJson) {
        if (entryQuestionnaire.getAge() > HIGH_RISK_AGE
                || entryQuestionnaire.isBelongsToRiskCategory()
                || entryQuestionnaire.isLivesWithPeopleOfRiskCategory()) {

            scoreJson.setDaysLeftToMeet(NO_MEET_EVER_IDENTIFICATION_NUMBER);
            scoreJson.setNoMeet(true);
        }

    }

    private void calculateMeetIn2Weeks(ScoreJson scoreJson) {
        if (entryQuestionnaire.isHadSymptoms()
                || entryQuestionnaire.isHasTraveledAbroad()
                || entryQuestionnaire.isHasMetInfectedPeopleInTheLast2Weeks()) {
            scoreJson.setDaysLeftToMeet(MAX_DAYS_LEFT_TO_MEET);
            scoreJson.setNoMeet(true);
        }
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
                        || a.equalsIgnoreCase("Wear a mask"))
                .count() * 200;

        scoreValue += entryQuestionnaire.getRegularPreventiveMeasures()
                .stream()
                .map(String::trim)
                .filter(Strings::isNotEmpty)
                .filter(a -> a.equalsIgnoreCase("Keep distance from other people"))
                .count() * 200;

        return scoreValue;
    }
}
