package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OnOtpResendResponse;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OtpCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.UpdateDetailsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.VerifyOtpCallBack;

/**
 * Created by aman on 6/9/17.
 */

public interface SignUpProvider {
    void requestOtp(String name,String mobile,String email,OtpCallBack otpCallBack);
    void verifyOtp(String temp_access_token,String otp,VerifyOtpCallBack verifyOtpCallBack);
    void resendOtp(String temp_access_token, OnOtpResendResponse onOtpResendResponse);

    void updateDetails(String access_token, String name, String college, String password,
                       UpdateDetailsCallBack updateDetailsCallBack);

}
