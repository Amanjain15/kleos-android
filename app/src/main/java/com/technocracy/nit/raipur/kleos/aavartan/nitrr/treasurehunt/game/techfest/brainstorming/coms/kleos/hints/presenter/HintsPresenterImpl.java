package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.HintsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.HintsProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data.HintsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.view.HintsView;

/**
 * Created by aman on 15/9/17.
 */

public class HintsPresenterImpl implements HintsPresenter {

    private HintsView hintsView;
    private HintsProvider hintsProvider;

    public HintsPresenterImpl(HintsView hintsView, HintsProvider hintsProvider) {
        this.hintsView = hintsView;
        this.hintsProvider = hintsProvider;
    }

    @Override
    public void requestHints(String access_token) {
        hintsView.showLoading(true);
        hintsProvider.requestHints(access_token, new HintsCallBack() {
            @Override
            public void onSuccess(HintsData hintsData) {
                try {
                    if (hintsData.isSuccess()){
                        hintsView.showLoading(false);
                        hintsView.setData(hintsData);

                    }else {
                        hintsView.showLoading(false);
                        hintsView.showMessage(hintsData.getMessage());
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                    hintsView.showMessage("Success Null");
                    hintsView.showLoading(false);
                }
            }

            @Override
            public void onFailure(String s) {
                hintsView.showLoading(false);
                hintsView.showMessage(s);
            }
        });

    }
}
