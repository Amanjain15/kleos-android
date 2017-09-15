package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data;

public class AboutUsData {
    boolean success;
    String message;
    String text;

    public AboutUsData(boolean success, String message, String text) {
        this.success = success;
        this.message = message;
        this.text = text;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getText() {
        return text;
    }
}