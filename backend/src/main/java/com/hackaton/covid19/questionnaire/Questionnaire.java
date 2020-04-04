package com.hackaton.covid19.questionnaire;

import java.util.List;

public class Questionnaire {
    private List<Question> questions;

    public Questionnaire(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
