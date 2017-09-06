package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.presenter;

/**
 * Created by aman on 6/9/17.
 */

public interface ForgotPresenter {
    void requestForgot(String mobile);
    void responseForgot(String mobile,String otp,String password);
}
