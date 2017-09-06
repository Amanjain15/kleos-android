package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model;

import android.os.Handler;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.HomeCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class MockHomeProvider implements HomeTabsProvider {
    private TabsData mockTabData;

    @Override
    public void getTabs(String access_token, final HomeCallBack homeCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                homeCallBack.onSuccess(getMockTabData());
            }
        },1000);
    }

    public TabsData getMockTabData() {
        List<TabDetails> tabDetailses = new ArrayList<>();

        for (int i =0,j=5 ;i < 6 && j>=0;i++,j--){
            TabDetails tabDetails = new TabDetails("TabId " + j,i,j);
            tabDetailses.add(tabDetails);
        }
        return new TabsData(true,"Successful",tabDetailses);
    }
}
