package com.hackaton.covid19.pandebuddies.application.outbound_ports;

import com.hackaton.covid19.pandebuddies.application.PandeBuddiesDocument;
import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;

public interface PandeBuddiesPresenter {
    void present(PandeBuddiesDocument pandeBuddiesDocument);
    void add(PandeBuddyDocument pandeBuddyDocument);
}
