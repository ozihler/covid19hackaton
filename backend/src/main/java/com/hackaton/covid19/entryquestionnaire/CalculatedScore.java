package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;

public class CalculatedScore {
    public static int THRESHOLD_SCORE = 1000;
    private EntryQuestionnaire entryQuestionnaire;

    public CalculatedScore(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }

    public ScoreJson value() {
        var entryQuestionnaireScore = new EntryQuestionnaireScore(entryQuestionnaire);

        return entryQuestionnaireScore.score();
    }

}
