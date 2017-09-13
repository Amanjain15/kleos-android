package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class SponserDetails {
    String image_url;
    String name;
    String web_url;

    public SponserDetails(String image_url, String name, String web_url) {
        this.image_url = image_url;
        this.name = name;
        this.web_url = web_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getName() {
        return name;
    }

    public String getWeb_url() {
        return web_url;
    }
}