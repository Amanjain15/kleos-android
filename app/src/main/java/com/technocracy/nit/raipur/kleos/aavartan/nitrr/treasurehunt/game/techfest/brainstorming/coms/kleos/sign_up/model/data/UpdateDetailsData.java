package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class UpdateDetailsData {
    private boolean success;
    private String message;

    public UpdateDetailsData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
