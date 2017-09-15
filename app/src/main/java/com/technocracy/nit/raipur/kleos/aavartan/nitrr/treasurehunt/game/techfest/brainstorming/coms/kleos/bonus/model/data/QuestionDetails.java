package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data;

/**
 * Created by aman on 12/9/17.
 */

public class QuestionDetails {

    private String question_name;
    private String question_content;
    private String question_img;
    private String question_no;

    public QuestionDetails(String question_name, String question_content,
                           String question_img, String question_no) {
        this.question_name = question_name;
        this.question_content = question_content;
        this.question_img = question_img;
        this.question_no = question_no;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public String getQuestion_img() {
        return question_img;
    }

    public String getQuestion_no() {
        return question_no;
    }
}
