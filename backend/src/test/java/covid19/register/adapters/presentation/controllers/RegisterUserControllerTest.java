package covid19.register.adapters.presentation.controllers;


import com.hackaton.covid19.register.adapters.presentation.controllers.RegisterUserController;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UserJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterUserControllerTest {

    @Test
    void test() {
        var repo = new InMemoryUserRepository();
        var controller = new RegisterUserController(repo, repo);
        ResponseEntity<UserJson> response = controller.registerUserWith(new UsernameJson("Olly"));

        assertEquals("Olly", response.getBody().getUsername());
        assertEquals(1, repo.count());

    }

    @Test
    void testException() {
        var repo = new InMemoryUserRepository();
        var controller = new RegisterUserController(repo, repo);
        controller.registerUserWith(new UsernameJson("Olly"));

        assertThrows(UserAlreadyRegisteredException.class, () -> controller.registerUserWith(new UsernameJson("Olly")));


    }

}