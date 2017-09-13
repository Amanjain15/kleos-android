package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data;

/**
 * Created by meghalagrawal on 14/07/17.
 */

public class ResendOtpData {

    private boolean success;
    private String message;

    public ResendOtpData(boolean success, String message) {
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
