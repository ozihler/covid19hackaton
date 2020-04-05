package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.entryquestionnaire.EntryQuestionnaireService;
import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import com.hackaton.covid19.shared.adapters.data_access.InMemoryPandeBuddyRepository;
import com.hackaton.covid19.shared.domain.values.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SubmitDailyQuestionnaireResource {

    private DailyQuestionnaireService dailyQuestionnaireService;
    private InMemoryPandeBuddyRepository repository;

    @Autowired
    public SubmitDailyQuestionnaireResource(DailyQuestionnaireService dailyQuestionnaireService ) {
        this.dailyQuestionnaireService = dailyQuestionnaireService;
        this.repository = repository;
    }

    @PostMapping("dailyQuestionnaire")
    public ResponseEntity<ScoreJson> submitDailyQuestionnaire(@RequestHeader("pandeName") String pandeName, @RequestBody DailyQuestionnaire dailyQuestionnaire) {
        ScoreJson score = this.dailyQuestionnaireService.storeQuestionnaire(pandeName, dailyQuestionnaire);
        return ResponseEntity.ok(score);
    }

    @GetMapping("curentScore")
    public ResponseEntity<ScoreJson> getCurrentScore(@RequestHeader("pandeName") String pandeName) {
        ScoreJson score = dailyQuestionnaireService.getScoreFor(pandeName);
        return ResponseEntity.ok(score);
    }

}
