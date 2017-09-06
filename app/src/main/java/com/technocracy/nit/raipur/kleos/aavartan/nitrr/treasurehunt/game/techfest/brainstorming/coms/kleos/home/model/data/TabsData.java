package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class TabsData {
    boolean success;
    String message;
    TabsData tabsData;

    public TabsData(boolean success, String message, TabsData tabsData) {
        this.success = success;
        this.message = message;
        this.tabsData = tabsData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TabsData getTabsData() {
        return tabsData;
    }

    public void setTabsData(TabsData tabsData) {
        this.tabsData = tabsData;
    }
}
