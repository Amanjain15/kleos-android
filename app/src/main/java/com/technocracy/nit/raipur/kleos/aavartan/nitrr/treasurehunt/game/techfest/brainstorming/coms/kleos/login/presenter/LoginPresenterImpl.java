package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.LoginCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.LoginProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.data.LoginData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.view.LoginView;

/**
 * Created by aman on 5/9/17.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginProvider loginProvider;

    public LoginPresenterImpl(LoginView loginView, LoginProvider loginProvider) {
        this.loginView = loginView;
        this.loginProvider = loginProvider;
    }

    @Override
    public void requestLogin(String mobile, String password) {
        loginView.disable_login(false);
        loginView.showProgressBar(true);
        loginProvider.requestLogin(mobile, password, new LoginCallBack() {
            @Override
            public void onSuccess(LoginData loginData) {
                try {
                    if (loginData.isSuccess()) {
                        loginView.showProgressBar(false);
                        loginView.disable_login(true);
                        loginView.onLoginSuccess(loginData);
                    } else {
                        loginView.disable_login(true);
                        loginView.showMessage(loginData.getMessage());
                        loginView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    loginView.showMessage("Success Null");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String error) {
                loginView.disable_login(true);
                loginView.showMessage(error);
                loginView.showProgressBar(false);
            }
        });

    }
}
