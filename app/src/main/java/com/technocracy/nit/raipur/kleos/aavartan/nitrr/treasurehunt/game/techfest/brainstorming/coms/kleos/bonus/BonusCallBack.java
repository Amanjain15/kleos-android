package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionData;

/**
 * Created by aman on 6/9/17.
 */

public interface BonusCallBack {
    void onSuccess(QuestionData questionData);

    void onFailure(String s);
}
