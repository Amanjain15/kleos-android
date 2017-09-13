package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class TabsData {
    boolean success;
    String message;
    List<TabDetails> tabsDetailsList;

    public TabsData(boolean success, String message, List<TabDetails> tabsDetailsList) {
        this.success = success;
        this.message = message;
        this.tabsDetailsList = tabsDetailsList;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<TabDetails> getTabsDetailsList() {
        return tabsDetailsList;
    }
}