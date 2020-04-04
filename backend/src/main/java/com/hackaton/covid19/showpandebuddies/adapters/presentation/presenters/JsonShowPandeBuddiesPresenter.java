package com.hackaton.covid19.showpandebuddies.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.showpandebuddies.adapters.presentation.viewmodels.PandeBuddiesJson;
import com.hackaton.covid19.showpandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.showpandebuddies.application.outbound_ports.ShowPandeBuddiesPresenter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class JsonShowPandeBuddiesPresenter implements ShowPandeBuddiesPresenter {
    private ResponseEntity<PandeBuddiesJson> response;

    public ResponseEntity<PandeBuddiesJson> getResponse() {
        return this.response;
    }

    @Override
    public void present(PandeBuddiesDocument pandeBuddiesDocument) {
        List<PandeBuddyJson> pandeBuddies = toJsons(pandeBuddiesDocument);

        PandeBuddiesJson body = new PandeBuddiesJson(pandeBuddies);

        this.response = ResponseEntity.ok(body);
    }

    private List<PandeBuddyJson> toJsons(PandeBuddiesDocument pandeBuddiesDocument) {
        return pandeBuddiesDocument.getPandeBuddyDocuments()
                .stream()
                .map(this::toPandeBuddyJson)
                .collect(Collectors.toList());
    }

    private PandeBuddyJson toPandeBuddyJson(PandeBuddyDocument pandeBuddyDocument) {
        Username username = pandeBuddyDocument.getUsername();
        String value = username.value();
        return new PandeBuddyJson(value);
    }
}
