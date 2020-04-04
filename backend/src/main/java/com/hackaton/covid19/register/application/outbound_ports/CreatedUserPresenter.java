package com.hackaton.covid19.register.application.outbound_ports;

import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;

public interface CreatedUserPresenter {
    void present(PandeBuddyDocument pandeBuddyDocument, boolean exists);
}
