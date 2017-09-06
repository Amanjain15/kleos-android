package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models.data.ForgotData;

/**
 * Created by aman on 6/9/17.
 */

public interface ForgotPasswordCallBack {
    void onSuccess(ForgotData forgotData);
    void onFailure(String error);
}
