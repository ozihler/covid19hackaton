package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;

public class CalculatedScore {
    private EntryQuestionnaire entryQuestionnaire;

    public CalculatedScore(EntryQuestionnaire entryQuestionnaire) {
        this.entryQuestionnaire = entryQuestionnaire;
    }

    public ScoreJson value() {

        ScoreJson scoreJson = new ScoreJson();
        //int scoreValue = 0;if(entryQuestionnaire.get)
        return scoreJson;
    }
}
