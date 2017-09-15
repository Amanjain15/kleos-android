package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.AboutUsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.AboutUsProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data.AboutUsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.view.AboutUsView;

public class AboutUsPresenterImpl implements AboutUsPresenter {
    private AboutUsProvider aboutUsProvider;
    private AboutUsView aboutUsView;

    public AboutUsPresenterImpl(AboutUsProvider aboutUsProvider, AboutUsView aboutUsView) {
        this.aboutUsProvider = aboutUsProvider;
        this.aboutUsView = aboutUsView;
    }

    @Override
    public void getData(String access_token) {
        aboutUsView.showLoading(true);
        aboutUsProvider.getData(access_token, new AboutUsCallBack() {
            @Override
            public void onSuccess(AboutUsData aboutUsData) {
                aboutUsView.showLoading(false);
                if(aboutUsData.isSuccess())
                {
                    aboutUsView.showLoading(false);
                    aboutUsView.setData(aboutUsData);
                }
                else{
                    aboutUsView.showLoading(false);
                    aboutUsView.showMessage(aboutUsData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                 aboutUsView.showLoading(false);
                aboutUsView.showMessage("Unable to connect");
            }
        });
    }
}