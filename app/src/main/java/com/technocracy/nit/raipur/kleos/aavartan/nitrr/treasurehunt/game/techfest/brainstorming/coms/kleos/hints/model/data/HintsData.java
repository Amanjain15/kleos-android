package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data;

import java.util.List;

/**
 * Created by aman on 15/9/17.
 */

public class HintsData {
    private boolean success;
    private String message;
    private List<HintsDetails> hint_list;

    public HintsData(boolean success, String message, List<HintsDetails> hint_list) {
        this.success = success;
        this.message = message;
        this.hint_list = hint_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<HintsDetails> getHint_list() {
        return hint_list;
    }
}
