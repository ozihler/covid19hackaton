package com.hackaton.covid19.entryquestionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmitEntryQuestionnaireResource {

    private EntryQuestionnaireService entryQuestionnaireService;

    @Autowired
    public SubmitEntryQuestionnaireResource() {
    }

    @PostMapping("entryQuestionnaire")
    public ResponseEntity<EntryQuestionnaire> submitEntryQuestionnaire(@RequestHeader("pandeName") String pandeName, @RequestBody EntryQuestionnaire entryQuestionnaire) {
        EntryQuestionnaire stored = this.entryQuestionnaireService.storeQuestionnaire(pandeName,entryQuestionnaire);
        return ResponseEntity.ok(stored);
    }

}
