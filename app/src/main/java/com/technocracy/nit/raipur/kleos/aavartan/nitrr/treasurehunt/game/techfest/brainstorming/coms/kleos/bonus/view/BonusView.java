package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionData;

/**
 * Created by aman on 14/9/17.
 */

public interface BonusView {
    void setData(QuestionData questionData);
    void showLoading(boolean show);
    void showMessage(String message);

    void onRightAnswer();
}
