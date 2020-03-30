package com.zihler.covid19hackaton.adapters.presentation.resources;

import com.zihler.covid19hackaton.adapters.presentation.controllers.WelcomeMessageController;
import com.zihler.covid19hackaton.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/api/dummy")
    public ResponseEntity<WelcomeMessageViewModel> viewAllExercisesOfMuscleGroup(@RequestParam("eventName") String eventName) {
        logger.info("Received request with event name {}.", eventName);

        return welcomeMessageController.viewWelcomeMessage(eventName);
    }

}
