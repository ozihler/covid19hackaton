package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryPandeBuddyRepository;
import com.hackaton.covid19.shared.adapters.data_access.exceptions.PandeBuddyNotFoundException;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryQuestionnaireService {

    private InMemoryPandeBuddyRepository repository;

    @Autowired
    public EntryQuestionnaireService(InMemoryPandeBuddyRepository repository) {
        this.repository = repository;
    }

    public ScoreJson storeQuestionnaire(String pandeName, EntryQuestionnaire entryQuestionnaire) {
        Username username = Username.from(pandeName);
        if (!repository.exists(username)) {
            throw new PandeBuddyNotFoundException(username);
        }

        PandeBuddy pandeBuddy = repository.withUsername(username).get();
        pandeBuddy.setEntryQuestionnaire(entryQuestionnaire);
        repository.withValues(pandeBuddy);

        CalculatedScore calculatedScore = new CalculatedScore(entryQuestionnaire);
        return calculatedScore.value();
    }
}
