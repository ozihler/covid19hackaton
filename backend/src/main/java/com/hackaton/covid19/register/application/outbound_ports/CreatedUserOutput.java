package com.hackaton.covid19.register.application.outbound_ports;

import com.hackaton.covid19.register.application.documents.UserDocument;

public interface CreatedUserOutput {
    void present(UserDocument userDocument);
}
