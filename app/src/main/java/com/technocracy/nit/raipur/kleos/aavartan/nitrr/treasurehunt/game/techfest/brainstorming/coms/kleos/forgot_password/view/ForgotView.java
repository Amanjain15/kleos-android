package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.view;

/**
 * Created by aman on 6/9/17.
 */

public interface ForgotView {
    void showMessage(String message);

    void showProgressBar(boolean show);

    void onOtpSend();

    void onOtpVerified();

    void enable_password(boolean show);

    void enable_otp(boolean show);
}
