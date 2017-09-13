package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.ForgotPasswordCallBack;

/**
 * Created by aman on 6/9/17.
 */

public interface ForgotProvider {

    void requestForgot(String mobile, ForgotPasswordCallBack forgotPasswordCallBack);
    void responseForgot(String mobile, String otp, String password,
                                                    ForgotPasswordCallBack forgotPasswordCallBack);
}
