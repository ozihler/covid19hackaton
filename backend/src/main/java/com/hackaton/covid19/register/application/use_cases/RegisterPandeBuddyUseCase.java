package com.hackaton.covid19.register.application.use_cases;

import com.hackaton.covid19.register.application.outbound_ports.PandeBuddyDocument;
import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.register.application.use_cases.inbound_port.RegisterPandeBuddy;
import com.hackaton.covid19.register.domain.entities.PandeBuddy;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchPandeBuddy;
import com.hackaton.covid19.shared.application.outbound_ports.StorePandeBuddy;

public class RegisterPandeBuddyUseCase implements RegisterPandeBuddy {

    private FetchPandeBuddy fetchPandeBuddy;
    private StorePandeBuddy storePandeBuddy;

    public RegisterPandeBuddyUseCase(FetchPandeBuddy fetchPandeBuddy, StorePandeBuddy storePandeBuddy) {
        this.fetchPandeBuddy = fetchPandeBuddy;
        this.storePandeBuddy = storePandeBuddy;
    }

    @Override
    public void invokeWith(Username username, CreatedUserPresenter output) {
        if (fetchPandeBuddy.exists(username)) {
            throw new UserAlreadyRegisteredException(username.value());
        }
        var user = new PandeBuddy(username);
        var storedUser = storePandeBuddy.withValues(user);
        PandeBuddyDocument pandeBuddyDocument = toDocument(storedUser);
        output.present(pandeBuddyDocument);
    }

    private PandeBuddyDocument toDocument(PandeBuddy storedPandeBuddy) {
        return new PandeBuddyDocument(storedPandeBuddy.getUsername());
    }
}
