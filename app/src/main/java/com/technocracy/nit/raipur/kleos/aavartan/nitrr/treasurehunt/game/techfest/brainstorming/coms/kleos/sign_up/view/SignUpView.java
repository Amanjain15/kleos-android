package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;

/**
 * Created by aman on 6/9/17.
 */

public interface SignUpView {
    void showMessage(String message);

    void showProgressBar(boolean show);

    void onOtpSend(OtpData otpData);

    void onOtpVerified(SignUpRequestData signUpRequestData);

    void onDetailsUpdate(UpdateDetailsData updateDetailsData);


    void enable_signUp(boolean show);

    void enable_otp(boolean show);

    void enable_update(boolean show);


}
