package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data.AboutUsData;

/**
 * Created by aman on 6/9/17.
 */

public interface AboutUsCallBack {
    void onSuccess(AboutUsData aboutUsData);
    void onFailure();
}
