package com.truedialog.client.enums;

public enum QuestionType {

    /**
     * Question accepts yes/no responses.
     */
    /// A.K.A. boolean question type
    YESNO(1),

    /**
     * Question has multiple choices
     */
    MULTIPLECHOISE(2),

    /**
     * Question accepts any answer format.
     */
    /// Note that STOP is always handled by the stop processor, so that value will
    /// not get handled by an open response question.
    OPENRESPONSE(3);


    private int mQuestionType;

    private QuestionType(int questionType) {
        mQuestionType = questionType;
    }

    public int getValue() {
        return mQuestionType;
    }


    public static QuestionType questionType(int questionType) {
        QuestionType type = null;

        switch (questionType) {
            case 1:
                type =YESNO;
                break;
            case 2:
                type = MULTIPLECHOISE;
                break;
            case 3:
                type = OPENRESPONSE;
                break;
        }
        return type;
    }
}
