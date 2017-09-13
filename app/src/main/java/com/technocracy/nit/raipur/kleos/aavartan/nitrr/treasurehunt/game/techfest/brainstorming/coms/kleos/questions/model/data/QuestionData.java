package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data;

import java.util.List;

/**
 * Created by aman on 12/9/17.
 */

public class QuestionData {

    private boolean success;
    private String message;
    private QuestionDetails next_question;
    private List<QuestionDetails> solved_question_list;

    public QuestionData(boolean success, String message, QuestionDetails next_question,
                        List<QuestionDetails> solved_question_list) {
        this.success = success;
        this.message = message;
        this.next_question = next_question;
        this.solved_question_list = solved_question_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public QuestionDetails getNext_question() {
        return next_question;
    }

    public List<QuestionDetails> getSolved_question_list() {
        return solved_question_list;
    }
}
