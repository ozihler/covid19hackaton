package com.hackaton.covid19.shared.application.outbound_ports;

import com.hackaton.covid19.register.domain.entities.PandeBuddy;

public interface StorePandeBuddy {
    PandeBuddy withValues(PandeBuddy pandeBuddy);
}
