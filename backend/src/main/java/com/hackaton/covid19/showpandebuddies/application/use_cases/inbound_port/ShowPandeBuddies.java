package com.hackaton.covid19.showpandebuddies.application.use_cases.inbound_port;

import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.showpandebuddies.application.outbound_ports.ShowPandeBuddiesPresenter;

public interface ShowPandeBuddies {
    void invokeWith(Username username, ShowPandeBuddiesPresenter output);
}
