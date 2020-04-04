package com.hackaton.covid19.pandebuddies.application.use_cases.inbound_port;

import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.pandebuddies.application.outbound_ports.PandeBuddiesPresenter;

public interface PandeBuddiesInboundPort {
    void invokeWith(Username username, PandeBuddiesPresenter output);
    void invokeWith(Username newBuddyUsername, Username username, PandeBuddiesPresenter output);
}
