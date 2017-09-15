package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class SponserData {
    boolean succcess;
    String message;
    List<SponserDetails> sponserDetails;

    public SponserData(boolean succcess, String message, List<SponserDetails> sponserDetails) {
        this.succcess = succcess;
        this.message = message;
        this.sponserDetails = sponserDetails;
    }

    public boolean isSucccess() {
        return succcess;
    }

    public String getMessage() {
        return message;
    }

    public List<SponserDetails> getSponserDetails() {
        return sponserDetails;
    }
}
