package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.data.LoginData;

/**
 * Created by aman on 5/9/17.
 */

public interface LoginCallBack {
    void onSuccess(LoginData loginData);
    void onFailure(String error);
}
