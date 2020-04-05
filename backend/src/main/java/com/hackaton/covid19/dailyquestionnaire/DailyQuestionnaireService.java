package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.entryquestionnaire.CalculatedScore;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryPandeBuddyRepository;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyQuestionnaireService {

    private InMemoryPandeBuddyRepository repository;

    @Autowired
    public DailyQuestionnaireService(InMemoryPandeBuddyRepository repository) {
        this.repository = repository;
    }

    public ScoreJson storeQuestionnaire(String pandeName, DailyQuestionnaire dailyQuestionnaire) {
        Username username = Username.from(pandeName);
        if (!repository.exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }

        PandeBuddy pandeBuddy = repository.withUsername(username).get();
        List<DailyQuestionnaire> dailyQuestionnaires = pandeBuddy.getDailyQuestionnaires();
        dailyQuestionnaires.add(dailyQuestionnaire);
        CalculatedScoreDaily calculatedScore = new CalculatedScoreDaily(repository.withUsername(username).get());
        ScoreJson scoreValue = calculatedScore.value();
        pandeBuddy.setScore(scoreValue);
        return scoreValue;
    }

    public ScoreJson getScoreFor(String pandeName) {
        Username username = Username.from(pandeName);
        if (!repository.exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }

        PandeBuddy pandeBuddy = repository.withUsername(username).get();
        return pandeBuddy.getScore();
    }

}
