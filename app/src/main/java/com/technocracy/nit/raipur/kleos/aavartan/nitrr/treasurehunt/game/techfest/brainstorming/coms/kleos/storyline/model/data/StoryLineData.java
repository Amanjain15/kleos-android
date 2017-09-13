package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.data;

/**
 * Created by aman on 12/9/17.
 */

public class StoryLineData {
    private String message;
    private boolean success;
    private String image_url;
    private String story;

    public StoryLineData(String message, boolean success, String image_url, String story) {
        this.message = message;
        this.success = success;
        this.image_url = image_url;
        this.story = story;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getStory() {
        return story;
    }
}
