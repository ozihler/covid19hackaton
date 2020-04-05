package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.entryquestionnaire.CalculatedScore;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared_questionnaire.QuestionnaireHelper;

import java.util.List;

public class CalculatedScoreDaily {
    private PandeBuddy pandeBuddy;

    public CalculatedScoreDaily(PandeBuddy pandeBuddy) {
        this.pandeBuddy = pandeBuddy;
    }

    public ScoreJson value() {
        ScoreJson entryScoreJson = new CalculatedScore(pandeBuddy.getEntryQuestionnaire()).value();
        ScoreJson dailyScoreJson = new ScoreJson(0, QuestionnaireHelper.SAFE_COLOR, 0, false);
        ScoreJson finalScoreJson = new ScoreJson(0, QuestionnaireHelper.SAFE_COLOR, 0, false);

        List<DailyQuestionnaire> dailyQuestionnaires = pandeBuddy.getDailyQuestionnaires();

        for (DailyQuestionnaire dailyQuestionnaire:dailyQuestionnaires) {
            ScoreJson tempScoreJson = new DailyQuestionnaireScore(dailyQuestionnaire).score();
            dailyScoreJson.setValue(dailyScoreJson.getValue() + tempScoreJson.getValue());
            if(dailyScoreJson.getDaysLeftToMeet() < tempScoreJson.getDaysLeftToMeet()){
                dailyScoreJson.setDaysLeftToMeet(tempScoreJson.getDaysLeftToMeet());
                dailyScoreJson.setNoMeet(true);
                dailyScoreJson.setColor(tempScoreJson.getColor());
            }
        }

        if(entryScoreJson.isNoMeet() || dailyScoreJson.isNoMeet()){
            finalScoreJson.setColor(QuestionnaireHelper.DANGER_COLOR);
            finalScoreJson.setDaysLeftToMeet(Math.max(entryScoreJson.getDaysLeftToMeet(),dailyScoreJson.getDaysLeftToMeet()));
            finalScoreJson.setNoMeet(true);
        } else {
            int value = entryScoreJson.getValue() + dailyScoreJson.getValue();
            finalScoreJson.setValue(value);
            finalScoreJson.setColor(new QuestionnaireHelper().getColor(value));
        }
        return finalScoreJson;
    }
}
