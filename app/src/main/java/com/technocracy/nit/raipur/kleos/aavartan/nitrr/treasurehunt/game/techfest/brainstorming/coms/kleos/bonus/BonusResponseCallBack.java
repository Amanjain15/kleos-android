package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionResponseData;

/**
 * Created by aman on 13/9/17.
 */

public interface BonusResponseCallBack {
    void onSuccess(QuestionResponseData questionResponseData);

    void onFailure(String s);
}
