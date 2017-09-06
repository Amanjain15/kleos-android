package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up;


import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.ResendOtpData;

/**
 * Created by meghalagrawal on 14/07/17.
 */

public interface OnOtpResendResponse {

    void onSuccess(ResendOtpData resendOtpData);

    void onFailure(String message);

}
