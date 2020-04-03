package com.hackaton.covid19.register.application.use_cases;

import com.hackaton.covid19.register.application.outbound_ports.UserDocument;
import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.register.application.outbound_ports.CreatedUserPresenter;
import com.hackaton.covid19.register.application.use_cases.inbound_port.RegisterUser;
import com.hackaton.covid19.register.domain.entities.User;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.application.outbound_ports.FetchUser;
import com.hackaton.covid19.shared.application.outbound_ports.StoreUser;

public class RegisterUserUseCase implements RegisterUser {

    private FetchUser fetchUser;
    private StoreUser storeUser;

    public RegisterUserUseCase(FetchUser fetchUser, StoreUser storeUser) {
        this.fetchUser = fetchUser;
        this.storeUser = storeUser;
    }

    @Override
    public void invokeWith(Username username, CreatedUserPresenter output) {
        if (fetchUser.exists(username)) {
            throw new UserAlreadyRegisteredException(username.value());
        }
        var user = new User(username);
        var storedUser = storeUser.withValues(user);
        UserDocument userDocument = toDocument(storedUser);
        output.present(userDocument);
    }

    private UserDocument toDocument(User storedUser) {
        return new UserDocument(storedUser.getUsername());
    }
}
