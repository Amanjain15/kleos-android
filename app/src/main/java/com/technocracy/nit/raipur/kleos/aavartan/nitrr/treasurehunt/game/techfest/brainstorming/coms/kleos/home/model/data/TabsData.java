package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class TabsData {

    private boolean success;
    private String message;
    private List<TabDetails> tab_list;

    public TabsData(boolean success, String message, List<TabDetails> tab_list) {
        this.success = success;
        this.message = message;
        this.tab_list = tab_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


    public List<TabDetails> getTab_list() {
        return tab_list;
    }
}