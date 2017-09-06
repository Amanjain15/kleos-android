package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.WelcomeScreenCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.WelcomeProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view.WelcomeView;

/**
 * Created by aman on 1/9/17.
 */

public class WelcomePresenterImpl implements WelcomePresenter {

    private WelcomeView welcomeScreenView;
    private WelcomeProvider welcomeScreenProvider;

    public WelcomePresenterImpl(WelcomeView welcomeScreenView, WelcomeProvider welcomeScreenProvider) {
        this.welcomeScreenView = welcomeScreenView;
        this.welcomeScreenProvider = welcomeScreenProvider;
    }


    @Override
    public void getWelcomeData() {
        welcomeScreenView.showProgressBar(true);
        welcomeScreenProvider.getWelcomeData(new WelcomeScreenCallBack() {
            @Override
            public void onSuccess(WelcomeData welcomeData) {
                try {
                    if (welcomeData.isSuccess()) {
                        welcomeScreenView.setData(welcomeData.getSlider_data());
                        welcomeScreenView.showProgressBar(false);

                    } else {
                        welcomeScreenView.showMessage("Something went wrong");
                        welcomeScreenView.showProgressBar(false);
                    }
                }catch (NullPointerException e){
                    welcomeScreenView.showMessage("Invalid API");
                    welcomeScreenView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure(String error) {
                welcomeScreenView.showProgressBar(false);
                welcomeScreenView.showMessage(error);
            }
        });
    }
}
