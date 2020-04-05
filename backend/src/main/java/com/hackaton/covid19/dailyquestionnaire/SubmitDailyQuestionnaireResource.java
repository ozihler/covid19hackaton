package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SubmitDailyQuestionnaireResource {

    private DailyQuestionnaireService dailyQuestionnaireService;

    @Autowired
    public SubmitDailyQuestionnaireResource(DailyQuestionnaireService dailyQuestionnaireService ) {
        this.dailyQuestionnaireService = dailyQuestionnaireService;
    }

    @PostMapping("dailyQuestionnaire")
    public ResponseEntity<ScoreJson> submitDailyQuestionnaire(@RequestHeader("pandeName") String pandeName, @RequestBody DailyQuestionnaire dailyQuestionnaire) {
        ScoreJson score = this.dailyQuestionnaireService.storeQuestionnaire(pandeName, dailyQuestionnaire);
        return ResponseEntity.ok(score);
    }

    @GetMapping("currentScore")
    public ResponseEntity<ScoreJson> getCurrentScore(@RequestHeader("pandeName") String pandeName) {
        ScoreJson score = dailyQuestionnaireService.getScoreFor(pandeName);
        return ResponseEntity.ok(score);
    }

}
