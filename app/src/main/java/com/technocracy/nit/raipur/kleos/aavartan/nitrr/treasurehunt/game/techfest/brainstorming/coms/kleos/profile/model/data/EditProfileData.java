package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data;

import java.util.List;

/**
 * Created by aman on 11/9/17.
 */

public class EditProfileData {

    private String message;
    private boolean success;

    public EditProfileData(String message, boolean success) {

        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
