package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaire;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;

import java.util.List;

public class CalculatedScore {
    private PandeBuddy pandeBuddy;

    public CalculatedScore(PandeBuddy pandeBuddy) {
        this.pandeBuddy = pandeBuddy;
    }

    public ScoreJson value() {

        ScoreJson scoreJson = new ScoreJson();
        EntryQuestionnaire entryQuestionnaire = pandeBuddy.getEntryQuestionnaire();
        List<DailyQuestionnaire> dailyQuestionnaires = pandeBuddy.getDailyQuestionnaires();
        //TODO: berechnen
        return scoreJson;
    }
}
