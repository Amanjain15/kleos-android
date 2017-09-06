package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class TabDetails {

    String title;
    int position;
    String image_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public TabDetails(String title, int position, String image_url) {

        this.title = title;
        this.position = position;
        this.image_url = image_url;
    }
}
