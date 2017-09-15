package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class SponserData {
    private boolean success;
    private String message;
    private List<SponserDetails> sponserDetails;

    public SponserData(boolean success, String message, List<SponserDetails> sponserDetails) {
        this.success = success;
        this.message = message;
        this.sponserDetails = sponserDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SponserDetails> getSponserDetails() {
        return sponserDetails;
    }
}
