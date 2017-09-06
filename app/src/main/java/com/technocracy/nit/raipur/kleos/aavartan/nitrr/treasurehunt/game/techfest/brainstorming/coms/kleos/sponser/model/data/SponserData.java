package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class SponserData {
    boolean succcess;
    String message;
    SponserDetails sponserDetails;

    public SponserData(boolean succcess, String message, SponserDetails sponserDetails) {
        this.succcess = succcess;
        this.message = message;
        this.sponserDetails = sponserDetails;
    }

    public boolean isSucccess() {
        return succcess;
    }

    public void setSucccess(boolean succcess) {
        this.succcess = succcess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SponserDetails getSponserDetails() {
        return sponserDetails;
    }

    public void setSponserDetails(SponserDetails sponserDetails) {
        this.sponserDetails = sponserDetails;
    }
}
