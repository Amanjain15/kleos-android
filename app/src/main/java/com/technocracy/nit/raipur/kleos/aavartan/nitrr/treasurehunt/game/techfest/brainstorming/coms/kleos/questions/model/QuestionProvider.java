package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.QuestionRequestCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.QuestionResponseCallBack;

/**
 * Created by aman on 12/9/17.
 */

public interface QuestionProvider {

    void requestQuestions(String access_token, QuestionRequestCallBack questionRequestCallBack);

    void responseQuestion(String access_token, String question_no, String answer,
                          QuestionResponseCallBack questionResponseCallBack);
}
