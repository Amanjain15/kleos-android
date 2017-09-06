package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.data.LoginData;

/**
 * Created by aman on 5/9/17.
 */

public interface LoginView {
    void showMessage(String error);

    void showProgressBar(boolean show);

    void onLoginSuccess(LoginData loginData);

    void disable_login(boolean show);
}
