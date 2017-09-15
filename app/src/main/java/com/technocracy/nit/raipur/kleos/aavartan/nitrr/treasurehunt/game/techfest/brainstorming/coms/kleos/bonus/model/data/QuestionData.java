package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionDetails;

import java.util.List;

/**
 * Created by aman on 14/9/17.
 */

public class QuestionData {
    private boolean success;
    private String message;
    private boolean answered;
    private QuestionDetails question;

    public QuestionData(boolean success, String message, boolean answered, QuestionDetails bonus_question) {
        this.success = success;
        this.message = message;
        this.answered = answered;
        this.question = bonus_question;
    }

    public boolean isAnswered() {
        return answered;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public QuestionDetails getBonus_question() {
        return question;
    }
}
