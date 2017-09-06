package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;

/**
 * Created by aman on 6/9/17.
 */

public interface HomeView {
    void setTabs(TabsData tabsData);
    void showLoading(boolean show);
    void showMessage(String message);
}
