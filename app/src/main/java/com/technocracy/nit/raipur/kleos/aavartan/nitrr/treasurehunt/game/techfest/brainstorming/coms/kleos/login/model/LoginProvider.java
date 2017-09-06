package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.LoginCallBack;

/**
 * Created by aman on 5/9/17.
 */

public interface LoginProvider {
    void requestLogin(String mobile, String password, LoginCallBack loginCallBack);
}
