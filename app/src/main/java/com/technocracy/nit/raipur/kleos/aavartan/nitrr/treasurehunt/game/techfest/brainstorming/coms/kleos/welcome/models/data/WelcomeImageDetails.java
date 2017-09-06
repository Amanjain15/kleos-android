package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data;

/**
 * Created by aman on 1/9/17.
 */

public class WelcomeImageDetails {

    private int id;
    private String message;
    private String image_url;

    public WelcomeImageDetails(int image_id, String message, String image_url) {
        this.id = image_id;
        this.message = message;
        this.image_url = image_url;
    }

    public int getImage_id() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getImage_url() {
        return image_url;
    }
}
