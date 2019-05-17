package com.example.messanger;

public class TrueFalse {
    private int question;
    private boolean TrueQuestion;

    public TrueFalse(int question, boolean isTrueQuestion) {
        this.question = question;
        this.TrueQuestion = isTrueQuestion;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isTrueQuestion() {
        return TrueQuestion;
    }

}
