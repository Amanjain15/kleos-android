package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.SponserCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.SponserProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view.SponserView;

/**
 * Created by aman on 6/9/17.
 */

public class SponserPresenterImpl implements SponserPresenter {
    private SponserProvider sponserProvider;
    private SponserView sponserView;

    public SponserPresenterImpl(SponserProvider sponserProvider, SponserView sponserView) {
        this.sponserProvider = sponserProvider;
        this.sponserView = sponserView;
    }

    @Override
    public void sponsers(String access_token) {
        sponserView.showLoading(false);
        sponserProvider.sponsers(access_token, new SponserCallBack() {
            @Override
            public void onSuccess(SponserData sponserData) {
                if(sponserData.isSucccess())
                {
                    sponserView.showLoading(false);
                    sponserView.setSponsers(sponserData);
                }
                else
                {
                    sponserView.showLoading(false);
                    sponserView.showMessage(sponserData.getMessage());
                }
            }

            @Override
            public void onFailure() {

                sponserView.showLoading(false);
                sponserView.showMessage("Unable to connect to server");

            }
        });
    }
}
