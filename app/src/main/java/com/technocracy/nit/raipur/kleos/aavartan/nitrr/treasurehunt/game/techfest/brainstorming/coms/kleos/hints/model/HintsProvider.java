package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.HintsCallBack;

/**
 * Created by aman on 15/9/17.
 */

public interface HintsProvider {
    void requestHints(String acces_token, HintsCallBack hintsCallBack);
}
