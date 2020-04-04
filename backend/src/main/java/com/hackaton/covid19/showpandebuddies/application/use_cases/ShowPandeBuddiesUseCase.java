package com.hackaton.covid19.showpandebuddies.application.use_cases;

import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.showpandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddies;
import com.hackaton.covid19.showpandebuddies.application.outbound_ports.ShowPandeBuddiesPresenter;
import com.hackaton.covid19.showpandebuddies.application.use_cases.inbound_port.ShowPandeBuddies;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;

import java.util.List;

import static java.util.stream.Collectors.*;

public class ShowPandeBuddiesUseCase implements ShowPandeBuddies {

    private FetchPandeBuddies fetchPandeBuddies;

    public ShowPandeBuddiesUseCase(FetchPandeBuddies fetchPandeBuddies) {
        this.fetchPandeBuddies = fetchPandeBuddies;
    }

    @Override
    public void invokeWith(Username username, ShowPandeBuddiesPresenter output) {
        PandeBuddies pandeBuddies =  fetchPandeBuddies.forPandeBuddy(username);

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
        return new PandeBuddyDocument(pandeBuddy.getUsername());
    }

}
