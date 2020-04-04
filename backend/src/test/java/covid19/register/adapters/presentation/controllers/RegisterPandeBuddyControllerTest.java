package covid19.register.adapters.presentation.controllers;


import com.hackaton.covid19.register.adapters.presentation.controllers.RegisterPandeBuddyController;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.UsernameJson;
import com.hackaton.covid19.register.application.exceptions.UserAlreadyRegisteredException;
import com.hackaton.covid19.register.domain.values.Username;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryPandeBuddyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class RegisterPandeBuddyControllerTest {

    @Test
    void test() {
        var repo = new InMemoryPandeBuddyRepository();
        var controller = new RegisterPandeBuddyController(repo, repo);
        ResponseEntity<PandeBuddyJson> response = controller.registerUserWith(new UsernameJson("Olly"));

        assertEquals("Olly", response.getBody().getUsername());
        assertEquals(1, repo.count());
        assertTrue(repo.exists(Username.from("Olly")));

    }

    @Test
    void testException() {
        var repo = new InMemoryPandeBuddyRepository();
        var controller = new RegisterPandeBuddyController(repo, repo);
        controller.registerUserWith(new UsernameJson("Olly"));

        assertThrows(UserAlreadyRegisteredException.class, () -> controller.registerUserWith(new UsernameJson("Olly")));
    }

}
