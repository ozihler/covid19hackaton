package com.hackaton.covid19.updatescore;

import java.util.List;

public class Questionaire {
    private List<Question> questions;

    public Questionaire(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
