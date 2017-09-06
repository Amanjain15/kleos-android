package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;

/**
 * Created by aman on 6/9/17.
 */

public interface SponserCallBack {
    void onSuccess(SponserData sponserData);
    void onFailure();
}
