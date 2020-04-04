package com.hackaton.covid19.pandebuddies.adapters.presentation.resources;

import com.hackaton.covid19.pandebuddies.adapters.presentation.controllers.AddPandeBuddiesController;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.PandeBuddyJson;
import com.hackaton.covid19.shared.adapters.presentation.viewmodels.UsernameJson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddToPandeBuddiesResource {
    private AddPandeBuddiesController addedToBuddiesController;

    public AddToPandeBuddiesResource(AddPandeBuddiesController addedToBuddiesController) {
        this.addedToBuddiesController = addedToBuddiesController;
    }

    @PutMapping(
            path = "/pandebuddies/{pandeName}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PandeBuddyJson> addPandeBuddy(@RequestBody UsernameJson requestUsername, @PathVariable("pandeName") String pandeName){
        return this.addedToBuddiesController.addPandeBuddy(requestUsername, pandeName);
    }
}
