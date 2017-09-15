package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data.HintsData;

/**
 * Created by aman on 6/9/17.
 */

public interface HintsCallBack {
    void onSuccess(HintsData hintsData);

    void onFailure(String s);
}
