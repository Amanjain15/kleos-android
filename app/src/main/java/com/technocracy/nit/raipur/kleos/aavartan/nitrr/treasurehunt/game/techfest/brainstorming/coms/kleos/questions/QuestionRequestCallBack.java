package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;

/**
 * Created by aman on 12/9/17.
 */

public interface QuestionRequestCallBack {
    void onSuccess(QuestionData questionData);

    void onFailure(String s);
}
