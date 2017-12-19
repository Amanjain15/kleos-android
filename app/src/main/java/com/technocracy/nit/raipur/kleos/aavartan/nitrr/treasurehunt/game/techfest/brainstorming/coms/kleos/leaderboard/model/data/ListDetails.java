package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data;

/**
 * Created by aman on 19/9/17.
 */

public class ListDetails {
    private String rank;
    private String name;
    private String question_no;


    public ListDetails(String rank, String name, String question_no) {
        this.rank = rank;
        this.name = name;
        this.question_no = question_no;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getQuestion_no() {
        return question_no;
    }
}
