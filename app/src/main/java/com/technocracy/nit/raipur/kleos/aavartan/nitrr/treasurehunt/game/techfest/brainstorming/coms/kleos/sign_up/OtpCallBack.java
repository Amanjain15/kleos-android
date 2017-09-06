package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up;


import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;

/**
 * Created by aman on 28/6/17.
 */

public interface OtpCallBack {

    void onSuccess(OtpData otpData);
    void onFailure(String error);

}
