package com.hackaton.covid19.register.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;
import org.springframework.http.ResponseEntity;

public class RestCreatedUserPresenter implements CreatedUserPresenter {

    private ResponseEntity<PandeBuddyJson> response;

    public ResponseEntity<PandeBuddyJson> response() {
        return response;
    }

    @Override
    public void present(PandeBuddyDocument pandeBuddyDocument) {
        Username username = pandeBuddyDocument.getUsername();
        String value = username.value();
        PandeBuddyJson pandeBuddyJson = new PandeBuddyJson(
                pandeBuddyDocument.getUsername().value(),
                null,
                pandeBuddyDocument.getImageUrl(),
                toJson(pandeBuddyDocument.getScore())
        );

        pandeBuddyJson.setEntryQuestionnaire(pandeBuddyDocument.getEntryQuestionnaire());
        response = ResponseEntity.ok(pandeBuddyJson);
    }

    private ScoreJson toJson(Score score) {
        return new ScoreJson(
                score.getValue(),
                score.getColor(),
                score.getDaysLeftToMeet()
        );
    }
}
