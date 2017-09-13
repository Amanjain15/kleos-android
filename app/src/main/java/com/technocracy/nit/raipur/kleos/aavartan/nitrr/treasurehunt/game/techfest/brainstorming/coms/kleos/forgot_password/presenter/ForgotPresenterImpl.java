package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.ForgotPasswordCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models.ForgotProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models.data.ForgotData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.view.ForgotView;

/**
 * Created by aman on 6/9/17.
 */

public class ForgotPresenterImpl implements ForgotPresenter{

    private ForgotProvider forgotProvider;
    private ForgotView forgotView;

    public ForgotPresenterImpl(ForgotProvider forgotProvider, ForgotView forgotView) {
        this.forgotProvider = forgotProvider;
        this.forgotView = forgotView;
    }

    @Override
    public void requestForgot(String mobile) {
        forgotView.enable_otp(false);
        forgotView.showProgressBar(true);
        forgotProvider.requestForgot(mobile, new ForgotPasswordCallBack() {
            @Override
            public void onSuccess(ForgotData forgotData) {
                try {
                    if (forgotData.isSuccess()) {
                        forgotView.showProgressBar(false);
                        forgotView.enable_otp(true);
                        forgotView.onOtpSend();
                    } else {
                        forgotView.enable_otp(true);
                        forgotView.showMessage(forgotData.getMessage());
                        forgotView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    forgotView.showMessage("Success Null");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String error) {
                forgotView.showMessage(error);
                forgotView.showProgressBar(false);
                forgotView.enable_otp(true);
            }
        });
    }

    @Override
    public void responseForgot(String mobile, String otp, String password) {
        forgotView.enable_password(false);
        forgotView.showProgressBar(true);
        forgotProvider.responseForgot(mobile, otp, password, new ForgotPasswordCallBack() {
            @Override
            public void onSuccess(ForgotData forgotData) {
                try {
                    if (forgotData.isSuccess()) {
                        forgotView.onOtpVerified();
                        forgotView.showMessage(forgotData.getMessage());
                        forgotView.showProgressBar(false);
                    } else {
                        forgotView.showMessage(forgotData.getMessage());
                        forgotView.showProgressBar(false);
                        forgotView.enable_password(true);
                    }
                }catch (NullPointerException e){
                    forgotView.showMessage("Success Null");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String error) {
                forgotView.showMessage(error);
                forgotView.showProgressBar(false);
                forgotView.enable_password(true);
            }
        });
    }
}
