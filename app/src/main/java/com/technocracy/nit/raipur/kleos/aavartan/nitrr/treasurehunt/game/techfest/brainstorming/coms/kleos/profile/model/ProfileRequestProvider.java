package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.EditProfileCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.ProfileCallBack;

/**
 * Created by aman on 11/9/17.
 */

public interface ProfileRequestProvider {

    void requestProfile(String access_token, ProfileCallBack profileCallBack);
    void editProfile(String access_token, String name, String college, String email,
                     EditProfileCallBack editProfileCallBack);
}
