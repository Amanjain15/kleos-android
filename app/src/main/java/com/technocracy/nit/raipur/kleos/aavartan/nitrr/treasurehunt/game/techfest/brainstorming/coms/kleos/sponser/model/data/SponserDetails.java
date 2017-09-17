package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class SponserDetails {
    private String image_url;
    private String name;
    private String web_url;
    private String content;

    public SponserDetails(String image_url, String name, String web_url, String content) {
        this.image_url = image_url;
        this.name = name;
        this.web_url = web_url;
        this.content = content;
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

    public String getContent() {
        return content;
    }
}