package com.hackaton.covid19.updatescore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionaireResource {

    @GetMapping("/questionaire")
    public Questionaire getQuestionaire() {

        return new Questionaire(List.of(
                new Question("1", "What is your name", 10, "iconname")
        ));
    }

}
