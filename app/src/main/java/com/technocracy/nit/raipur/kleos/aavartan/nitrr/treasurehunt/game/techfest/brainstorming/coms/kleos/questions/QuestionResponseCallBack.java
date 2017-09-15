package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionResponseData;

/**
 * Created by aman on 13/9/17.
 */

public interface QuestionResponseCallBack {
    void onSuccess(QuestionResponseData questionResponseData);

    void onFailure(String s);
}
