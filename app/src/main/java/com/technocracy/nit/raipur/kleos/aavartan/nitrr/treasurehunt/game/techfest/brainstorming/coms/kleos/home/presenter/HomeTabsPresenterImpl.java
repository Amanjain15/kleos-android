package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.HomeCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.HomeTabsProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view.HomeView;

/**
 * Created by aman on 6/9/17.
 */

public class HomeTabsPresenterImpl implements HomeTabsPresenter {
    private HomeTabsProvider homeTabsProvider;
    private HomeView homeView;

    public HomeTabsPresenterImpl(HomeTabsProvider homeTabsProvider, HomeView homeView) {
        this.homeTabsProvider = homeTabsProvider;
        this.homeView = homeView;
    }

    @Override
    public void getTabs(String access_token) {
        homeView.showLoading(true);
        homeTabsProvider.getTabs(access_token, new HomeCallBack() {
            @Override
            public void onSuccess(TabsData tabsData) {
                if(tabsData.isSuccess())
                {
                    homeView.showLoading(false);
                    homeView.setTabs(tabsData);
                }
                else{
                    homeView.showLoading(false);
                    homeView.showMessage(tabsData.getMessage());
                }
            }

            @Override
            public void onFailure() {
                  homeView.showLoading(false);
                homeView.showMessage("Unable to connect to server");
            }
        });
    }
}
