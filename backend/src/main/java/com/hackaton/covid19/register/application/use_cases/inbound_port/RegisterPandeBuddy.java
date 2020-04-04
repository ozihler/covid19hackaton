package com.hackaton.covid19.register.application.use_cases.inbound_port;

import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.shared.domain.values.Username;

public interface RegisterPandeBuddy {
    void invokeWith(Username username, CreatedUserPresenter output);
}
