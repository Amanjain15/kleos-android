package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data;

/**
 * Created by aman on 6/9/17.
 */

public class TabDetails {

<<<<<<< HEAD
    String title;
    int position;
    int value;
    String image_url;

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }

    public void setTitle(String title) {
=======
    private String title;
    private int id;

    public TabDetails(String title,  int id) {
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
        this.title = title;

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

<<<<<<< HEAD
    public TabDetails(String title, int position, int value, String image_url) {
        this.title = title;
        this.position = position;
        this.value = value;
        this.image_url = image_url;
    }
=======

>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
}
