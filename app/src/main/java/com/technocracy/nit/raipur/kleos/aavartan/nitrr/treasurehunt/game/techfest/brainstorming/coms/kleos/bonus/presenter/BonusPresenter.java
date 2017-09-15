package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.BonusProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.view.BonusView;

/**
 * Created by aman on 14/9/17.
 */

public interface BonusPresenter {

    void requestQuestion(String access_token);
    void responseQuestion(String access_token, String question_no, String answer);

}
