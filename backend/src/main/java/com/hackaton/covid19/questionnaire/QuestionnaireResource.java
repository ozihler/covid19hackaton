package com.hackaton.covid19.questionnaire;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionnaireResource {

    @GetMapping("/questionnaire")
    public Questionnaire getQuestionnaire() {

        return new Questionnaire(List.of(
                new Question("1", "What is your name", 10, "iconname")
        ));
    }

}
