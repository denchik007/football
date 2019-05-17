package com.example.messanger;

public class TrueFalse {
    private int question;
    private boolean isTrueQuestion;

    public TrueFalse(int question, boolean isTrueQuestion) {
        this.question = question;
        this.isTrueQuestion = isTrueQuestion;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isTrueQuestion() {
        return isTrueQuestion;
    }

}
