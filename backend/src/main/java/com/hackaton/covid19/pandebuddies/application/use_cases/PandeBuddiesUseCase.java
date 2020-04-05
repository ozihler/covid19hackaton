package com.hackaton.covid19.pandebuddies.application.use_cases;

import com.hackaton.covid19.shared.application.outbound_ports.*;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.pandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.pandebuddies.application.outbound_ports.PandeBuddiesPresenter;
import com.hackaton.covid19.pandebuddies.application.use_cases.inbound_port.PandeBuddiesInboundPort;

import java.util.List;

import static java.util.stream.Collectors.*;

public class PandeBuddiesUseCase implements PandeBuddiesInboundPort {

    private FetchPandeBuddies fetchPandeBuddies;
    private FetchPandeBuddy pandeBuddy;

    public PandeBuddiesUseCase(FetchPandeBuddies fetchPandeBuddies) {
        this.fetchPandeBuddies = fetchPandeBuddies;
    }

    public PandeBuddiesUseCase(FetchPandeBuddy pandeBuddy){
        this.pandeBuddy = pandeBuddy;
    }

    @Override
    public void invokeWith(Username username, PandeBuddiesPresenter output) {
        PandeBuddies pandeBuddies =  fetchPandeBuddies.forPandeBuddy(username);
        PandeBuddiesDocument pandeBuddiesDocument = toDocument(pandeBuddies);
        output.present(pandeBuddiesDocument);
    }

    @Override
    public void invokeWith(Username newBuddyUsername, Username username, PandeBuddiesPresenter output) {
        PandeBuddy addedToBuddiesPandeBuddy = pandeBuddy.addToPandeBuddies(newBuddyUsername, username);
        PandeBuddyDocument pandeBuddyDocument = toDocument(addedToBuddiesPandeBuddy);
        output.add(pandeBuddyDocument);
    }

    @Override
    public void searchWith(Username pandename, Username buddyname, PandeBuddiesPresenter output) {
        PandeBuddies pandeBuddies =  fetchPandeBuddies.searchPandeBuddies(pandename, buddyname);
        PandeBuddiesDocument pandeBuddiesDocument = toDocument(pandeBuddies);
        output.present(pandeBuddiesDocument);
    }

    private PandeBuddiesDocument toDocument(PandeBuddies pandeBuddies) {
        List<PandeBuddyDocument> pandeBuddyDocuments = pandeBuddies.getPandeBuddies()
                .stream()
                .map(this::toDocument)
                .collect(toList());

        return new PandeBuddiesDocument(pandeBuddyDocuments);
    }

    private PandeBuddyDocument toDocument(PandeBuddy pandeBuddy) {
        PandeBuddyDocument pandeBuddyDocument = new PandeBuddyDocument(pandeBuddy.getUsername(), null, pandeBuddy.getImageUrl(), pandeBuddy.getScore());
        pandeBuddyDocument.setEntryQuestionnaire(pandeBuddy.getEntryQuestionnaire());
        pandeBuddyDocument.setPanikButtonFlag(pandeBuddy.isPanikButtonFlag());
        return pandeBuddyDocument;
    }

}
