package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;

/**
 * Created by aman on 6/9/17.
 */

public interface UpdateDetailsCallBack {

    void onSuccess(UpdateDetailsData updateDetailsData);
    void onFailure(String e);
}
