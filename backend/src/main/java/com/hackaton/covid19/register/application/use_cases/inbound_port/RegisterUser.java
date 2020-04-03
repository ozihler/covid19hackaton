package com.hackaton.covid19.register.application.use_cases.inbound_port;

import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.register.domain.values.Username;

public interface RegisterUser {
    void invokeWith(Username username, CreatedUserPresenter output);
}
