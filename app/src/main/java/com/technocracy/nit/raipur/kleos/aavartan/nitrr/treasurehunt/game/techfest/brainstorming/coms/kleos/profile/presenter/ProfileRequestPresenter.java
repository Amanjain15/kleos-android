package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.presenter;

/**
 * Created by aman on 11/9/17.
 */

public interface ProfileRequestPresenter {

    void requestProfile(String access_token);
    void editProfile(String access_token, String name, String college, String email);
}
