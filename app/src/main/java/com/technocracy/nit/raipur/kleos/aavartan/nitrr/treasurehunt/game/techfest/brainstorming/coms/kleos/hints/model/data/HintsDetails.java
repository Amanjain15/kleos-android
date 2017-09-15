package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data;

/**
 * Created by aman on 15/9/17.
 */

public class HintsDetails {

    private String question_name;
    private String question_no;
    private String question_img;
    private String hint;

    public HintsDetails(String question_name, String question_no, String question_img, String hint) {
        this.question_name = question_name;
        this.question_no = question_no;
        this.question_img = question_img;
        this.hint = hint;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public String getQuestion_no() {
        return question_no;
    }

    public String getQuestion_img() {
        return question_img;
    }

    public String getHint() {
        return hint;
    }
}
