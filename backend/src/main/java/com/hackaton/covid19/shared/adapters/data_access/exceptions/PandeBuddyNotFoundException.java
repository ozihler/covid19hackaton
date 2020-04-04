package com.hackaton.covid19.shared.adapters.data_access.exceptions;

import com.hackaton.covid19.shared.domain.values.Username;

public class PandeBuddyNotFoundException extends RuntimeException {
    public PandeBuddyNotFoundException(Username username) {
        super("Could not find Pande Buddy with username: " + username);
    }
}
