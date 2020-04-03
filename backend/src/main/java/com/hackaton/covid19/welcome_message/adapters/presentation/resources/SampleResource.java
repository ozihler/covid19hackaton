package com.hackaton.covid19.welcome_message.adapters.presentation.resources;

import com.hackaton.covid19.welcome_message.adapters.presentation.controllers.WelcomeMessageController;
import com.hackaton.covid19.welcome_message.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {
    private static final Logger logger = LoggerFactory.getLogger(SampleResource.class);
    private final WelcomeMessageController welcomeMessageController;

    @Autowired
    public SampleResource(WelcomeMessageController welcomeMessageController ) {
        this.welcomeMessageController = welcomeMessageController;
    }

    @GetMapping(path = "/dummy")
    public ResponseEntity<WelcomeMessageViewModel> viewAllExercisesOfMuscleGroup(@RequestParam("eventName") String eventName) {
        logger.info("Received request with event name {}.", eventName);

        return welcomeMessageController.viewWelcomeMessage(eventName);
    }

}
