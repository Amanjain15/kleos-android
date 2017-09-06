package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data;

import java.util.List;

/**
 * Created by aman on 1/9/17.
 */

public class WelcomeData {
    private boolean success;
    private String message;
    private List<WelcomeImageDetails> welcome_page;

    public WelcomeData(boolean success, String message, List<WelcomeImageDetails> slider_data) {
        this.success = success;
        this.message = message;
        this.welcome_page = slider_data;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<WelcomeImageDetails> getSlider_data() {
        return welcome_page;
    }
}
