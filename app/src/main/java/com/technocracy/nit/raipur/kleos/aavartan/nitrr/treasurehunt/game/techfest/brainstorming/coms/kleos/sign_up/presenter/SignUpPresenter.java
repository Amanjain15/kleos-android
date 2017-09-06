package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.presenter;

/**
 * Created by aman on 6/9/17.
 */

public interface SignUpPresenter {

    void requestOtp(String name,String mobile,String email);
    void verifyOtp(String temp_access_token,String otp);
    void resendOtp(String temp_access_token);
    void updateDetails(String access_token, String name, String college, String password);

}
