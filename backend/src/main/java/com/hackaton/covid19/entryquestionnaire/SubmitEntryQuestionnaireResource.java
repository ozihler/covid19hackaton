package com.hackaton.covid19.entryquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmitEntryQuestionnaireResource {
    Logger logger = LoggerFactory.getLogger(SubmitEntryQuestionnaireResource.class);

    private EntryQuestionnaireService entryQuestionnaireService;

    @Autowired
    public SubmitEntryQuestionnaireResource(EntryQuestionnaireService entryQuestionnaireService) {
        this.entryQuestionnaireService = entryQuestionnaireService;
    }

    @PostMapping("entryQuestionnaire")
    public ResponseEntity<ScoreJson> submitEntryQuestionnaire(@RequestHeader("pandeName") String pandeName, @RequestBody EntryQuestionnaire entryQuestionnaire) {
        logger.info("Received " + entryQuestionnaire + " for user " + pandeName);
        ScoreJson score = this.entryQuestionnaireService.storeQuestionnaire(pandeName, entryQuestionnaire);
        return ResponseEntity.ok(score);
    }

}
