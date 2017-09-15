package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter;

/**
 * Created by aman on 12/9/17.
 */

public interface QuestionPresenter {

    void requestQuestion(String access_token);
    void responseQuestion(String access_token, String question_no, String answer);
}
