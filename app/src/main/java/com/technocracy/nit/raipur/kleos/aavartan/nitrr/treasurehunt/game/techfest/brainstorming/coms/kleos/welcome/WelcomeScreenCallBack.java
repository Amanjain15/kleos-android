package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeData;

/**
 * Created by aman on 1/9/17.
 */

public interface WelcomeScreenCallBack {

    void onSuccess(WelcomeData welcomeData);
    void onFailure(String error);
}
