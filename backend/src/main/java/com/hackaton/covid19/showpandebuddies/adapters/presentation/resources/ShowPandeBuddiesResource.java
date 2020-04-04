package com.hackaton.covid19.showpandebuddies.adapters.presentation.resources;

import com.hackaton.covid19.showpandebuddies.adapters.presentation.controllers.ShowPandeBuddiesController;
import com.hackaton.covid19.showpandebuddies.adapters.presentation.viewmodels.PandeBuddiesJson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ShowPandeBuddiesResource {
    private ShowPandeBuddiesController showPandeBuddiesController;

    public ShowPandeBuddiesResource(ShowPandeBuddiesController showPandeBuddiesController) {
        this.showPandeBuddiesController = showPandeBuddiesController;
    }

    @GetMapping(
            path = "/pandebuddies/{pandeName}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<PandeBuddiesJson> getPandeBuddies(@PathVariable("pandeName") String pandeName) {
        return this.showPandeBuddiesController.showPandeBuddiesFor(pandeName);
    }
}
