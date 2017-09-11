package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.EditProfileData;

/**
 * Created by aman on 11/9/17.
 */

public interface EditProfileCallBack {
    void onSuccess(EditProfileData editProfileData);
    void onFailure(String r);
}
