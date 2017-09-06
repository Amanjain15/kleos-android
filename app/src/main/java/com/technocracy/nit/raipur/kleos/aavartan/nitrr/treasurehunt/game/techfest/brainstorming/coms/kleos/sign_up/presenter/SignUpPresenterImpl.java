package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OnOtpResendResponse;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OtpCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.UpdateDetailsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.VerifyOtpCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.SignUpProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.ResendOtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.view.SignUpView;

/**
 * Created by aman on 6/9/17.
 */

public class SignUpPresenterImpl implements SignUpPresenter{

    private SignUpView signUpView;
    private SignUpProvider signUpProvider;

    public SignUpPresenterImpl(SignUpView signUpView, SignUpProvider signUpProvider) {
        this.signUpView = signUpView;
        this.signUpProvider = signUpProvider;
    }


    @Override
    public void requestOtp(String name, String mobile, String email) {
        signUpView.enable_signUp(false);
        signUpView.showProgressBar(true);
        signUpProvider.requestOtp(name, mobile, email, new OtpCallBack() {
            @Override
            public void onSuccess(OtpData otpData) {
                try {

                    if(otpData.isSuccess()){
                        signUpView.onOtpSend(otpData);
                        signUpView.enable_signUp(false);
                        signUpView.showProgressBar(false);
                    }else{
                        signUpView.showMessage(otpData.getMessage());
                        signUpView.enable_signUp(true);
                        signUpView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    signUpView.showMessage("Success Null");
                    signUpView.enable_signUp(true);
                    signUpView.showProgressBar(false);
                }

            }

            @Override
            public void onFailure(String error) {
                signUpView.showMessage(error);
                signUpView.enable_signUp(true);
                signUpView.showProgressBar(false);
            }
        });
    }

    @Override
    public void verifyOtp(String temp_access_token, String otp) {
        signUpView.enable_otp(false);
        signUpView.showProgressBar(true);
        signUpProvider.verifyOtp(temp_access_token, otp, new VerifyOtpCallBack() {
            @Override
            public void onSuccess(SignUpRequestData signUpRequestData) {
                try {
                    if(signUpRequestData.isSuccess()){
                        signUpView.onOtpVerified(signUpRequestData);
                        signUpView.enable_otp(false);
                        signUpView.showProgressBar(false);
                        signUpView.showMessage(signUpRequestData.getMessage());
                    }else{
                        signUpView.showMessage(signUpRequestData.getMessage());
                        signUpView.enable_otp(true);
                        signUpView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    signUpView.showMessage("Success Null");
                    signUpView.enable_otp(true);
                    signUpView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure(String error) {
                signUpView.showMessage(error);
                signUpView.enable_otp(true);
                signUpView.showProgressBar(false);
            }
        });
    }

    @Override
    public void resendOtp(String temp_access_token) {
        signUpView.showProgressBar(true);
        signUpProvider.resendOtp(temp_access_token, new OnOtpResendResponse() {
            @Override
            public void onSuccess(ResendOtpData resendOtpData) {
                try {
                    if(resendOtpData.isSuccess()){
                        signUpView.showMessage("Otp Resent");
                        signUpView.showProgressBar(false);
                    }else {
                        signUpView.showMessage(resendOtpData.getMessage());
                        signUpView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    signUpView.showMessage("Success Null");
                    signUpView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure(String message) {
                signUpView.showMessage(message);
                signUpView.showProgressBar(false);
            }
        });
    }

    @Override
    public void updateDetails(String access_token, String name, String college, String password) {
        signUpView.enable_update(false);
        signUpView.showProgressBar(true);
        signUpProvider.updateDetails(access_token, name, college, password, new UpdateDetailsCallBack() {
            @Override
            public void onSuccess(UpdateDetailsData updateDetailsData) {
                try {
                    if (updateDetailsData.isSuccess()){
                        signUpView.showMessage(updateDetailsData.getMessage());
                        signUpView.onDetailsUpdate(updateDetailsData);
                        signUpView.showProgressBar(false);
                    }else {
                        signUpView.showMessage(updateDetailsData.getMessage());
                        signUpView.showProgressBar(false);
                        signUpView.enable_update(true);
                    }
                }catch (NullPointerException e){
                    signUpView.showMessage("Success Null");
                    signUpView.enable_update(true);
                    signUpView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure(String e) {
                signUpView.enable_update(true);
                signUpView.showMessage(e);
                signUpView.showProgressBar(false);

            }
        });
    }
}
