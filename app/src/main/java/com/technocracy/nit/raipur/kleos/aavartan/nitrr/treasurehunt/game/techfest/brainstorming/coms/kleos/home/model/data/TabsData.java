package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class TabsData {
<<<<<<< HEAD
    boolean success;
    String message;
    List<TabDetails> tabsDetailsList;

    public TabsData(boolean success, String message, List<TabDetails> tabsDetailsList) {
        this.success = success;
        this.message = message;
        this.tabsDetailsList = tabsDetailsList;
=======
    private boolean success;
    private String message;
    private List<TabDetails> tab_list;

    public TabsData(boolean success, String message, List<TabDetails> tab_list) {
        this.success = success;
        this.message = message;
        this.tab_list = tab_list;
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

<<<<<<< HEAD
    public List<TabDetails> getTabsDetailsList() {
        return tabsDetailsList;
=======
    public List<TabDetails> getTab_list() {
        return tab_list;
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
    }
}