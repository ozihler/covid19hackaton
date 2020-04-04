package com.hackaton.covid19.pandebuddies.adapters.presentation.presenters;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.pandebuddies.adapters.presentation.viewmodels.PandeBuddiesJson;
import com.hackaton.covid19.pandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.pandebuddies.application.outbound_ports.PandeBuddiesPresenter;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class JsonPandeBuddiesPresenter implements PandeBuddiesPresenter {
    private ResponseEntity<PandeBuddiesJson> responsePandeBuddies;
    public ResponseEntity<PandeBuddiesJson> getResponsePandeBuddies() { return this.responsePandeBuddies; }

    private ResponseEntity<PandeBuddyJson> responsePandeBuddy;
    public ResponseEntity<PandeBuddyJson> getResponsePandeBuddy() {
        return this.responsePandeBuddy;
    }

    @Override
    public void present(PandeBuddiesDocument pandeBuddiesDocument) {
        List<PandeBuddyJson> pandeBuddies = toJsons(pandeBuddiesDocument);

        PandeBuddiesJson body = new PandeBuddiesJson(pandeBuddies);

        this.responsePandeBuddies = ResponseEntity.ok(body);
    }

    @Override
    public void add(PandeBuddyDocument pandeBuddyDocument) {
        PandeBuddyJson body = toPandeBuddyJson(pandeBuddyDocument);
        this.responsePandeBuddy = ResponseEntity.ok(body);
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
