package com.hackaton.covid19.dailyquestionnaire;

import com.hackaton.covid19.register.adapters.presentation.viewmodels.ScoreJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SubmitDailyQuestionnaireResource {

    private DailyQuestionnaireService dairyQuestionnaireService;

    @PostMapping("dailyQuestionnaire")
    public ResponseEntity<ScoreJson> submitDailyQuestionnaire(@RequestHeader("pandeName") String pandeName, @RequestBody DailyQuestionnaire dailyQuestionnaire) {
        ScoreJson score = this.dairyQuestionnaireService.storeQuestionnaire(pandeName,dailyQuestionnaire);
        return ResponseEntity.ok(score);
    }
}
