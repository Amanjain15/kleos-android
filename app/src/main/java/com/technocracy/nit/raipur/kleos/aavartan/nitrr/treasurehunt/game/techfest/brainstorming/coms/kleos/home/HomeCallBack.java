package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;

/**
 * Created by aman on 6/9/17.
 */

public interface HomeCallBack {
    void onSuccess(TabsData tabsData);
    void onFailure(String error);
}
