package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;

/**
 * Created by aman on 6/9/17.
 */

public interface VerifyOtpCallBack {

    void onSuccess(SignUpRequestData signUpRequestData);
    void onFailure(String error);
}
