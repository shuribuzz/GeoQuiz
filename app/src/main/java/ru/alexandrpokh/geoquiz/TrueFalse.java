package ru.alexandrpokh.geoquiz;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion, mIsCheat;

    public TrueFalse(int question, boolean trueQuestion, boolean isCheat) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mIsCheat = isCheat;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean isCheat() {
        return mIsCheat;
    }

    public void setIsCheat(boolean isCheat) {
        mIsCheat = isCheat;
    }
}
