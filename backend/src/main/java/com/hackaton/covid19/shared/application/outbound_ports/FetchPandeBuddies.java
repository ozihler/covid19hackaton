package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.shared.domain.values.Username;
import com.hackaton.covid19.shared.domain.values.PandeBuddies;

public interface FetchPandeBuddies {
    PandeBuddies forPandeBuddy(Username username);
}
