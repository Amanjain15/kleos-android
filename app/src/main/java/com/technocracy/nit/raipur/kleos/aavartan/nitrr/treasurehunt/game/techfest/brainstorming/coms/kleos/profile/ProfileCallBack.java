package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;

/**
 * Created by aman on 6/9/17.
 */

public interface ProfileCallBack {
    void onSuccess(ProfileRequestData profileRequestData);
    void onFailure(String e);
}
