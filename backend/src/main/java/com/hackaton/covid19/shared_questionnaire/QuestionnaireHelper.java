package com.hackaton.covid19.shared_questionnaire;

public class QuestionnaireHelper {

    public static final int NO_MEET_EVER_IDENTIFICATION_NUMBER = -1;
    public static final int HIGH_RISK_AGE = 65;
    public static final int MAX_DAYS_LEFT_TO_MEET = 14;
    public static final String DANGER_COLOR = "red";
    public static final String CAUTION_COLOR = "yellow";
    public static final String SAFE_COLOR = "green";
    public static int THRESHOLD_SCORE_GREEN = 600;
    public static int THRESHOLD_SCORE_YELLOW = 300;

    public String getColor(int value){
        if (value > QuestionnaireHelper.THRESHOLD_SCORE_GREEN){
            return QuestionnaireHelper.SAFE_COLOR;
        } else if (value > QuestionnaireHelper.THRESHOLD_SCORE_YELLOW){
           return QuestionnaireHelper.CAUTION_COLOR;
        } else {
            return QuestionnaireHelper.DANGER_COLOR;
        }
    }
}
