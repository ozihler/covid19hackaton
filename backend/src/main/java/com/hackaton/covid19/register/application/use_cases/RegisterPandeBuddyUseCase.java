package com.hackaton.covid19.register.application.use_cases;

import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.register.application.use_cases.inbound_port.RegisterPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;
import com.hackaton.covid19.shared.domain.entities.PandeBuddy;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;
import com.hackaton.covid19.shared.domain.values.Score;
import com.hackaton.covid19.shared.domain.values.Username;

import java.util.ArrayList;

public class RegisterPandeBuddyUseCase implements RegisterPandeBuddy {

    private FetchPandeBuddy fetchPandeBuddy;
    private StorePandeBuddy storePandeBuddy;

    public RegisterPandeBuddyUseCase(FetchPandeBuddy fetchPandeBuddy, StorePandeBuddy storePandeBuddy) {
        this.fetchPandeBuddy = fetchPandeBuddy;
        this.storePandeBuddy = storePandeBuddy;
    }

    @Override
    public void invokeWith(Username username, CreatedUserPresenter output) {
        PandeBuddy user;
        if (fetchPandeBuddy.exists(username)) {
            user = fetchPandeBuddy.withUsername(username).get();
            PandeBuddyDocument pandeBuddyDocument = toDocument(user);
            output.present(pandeBuddyDocument, true);
        } else {
            user = new PandeBuddy(username, new PandeBuddies(new ArrayList<PandeBuddy>()), "", new Score());
            user = storePandeBuddy.storePandeBuddy(user);
            PandeBuddyDocument pandeBuddyDocument = toDocument(user);
            output.present(pandeBuddyDocument, false);
        }
    }

    private PandeBuddyDocument toDocument(PandeBuddy storedPandeBuddy) {
        return new PandeBuddyDocument(
                storedPandeBuddy.getUsername(),
                null,
                storedPandeBuddy.getImageUrl(),
                storedPandeBuddy.getScore()
        );
    }
}
