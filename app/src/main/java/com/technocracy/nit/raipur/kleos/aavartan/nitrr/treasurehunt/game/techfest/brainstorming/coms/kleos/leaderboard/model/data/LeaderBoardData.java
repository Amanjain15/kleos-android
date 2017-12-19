package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data;

import java.util.List;

/**
 * Created by aman on 19/9/17.
 */

public class LeaderBoardData {

    private String message;
    private boolean success;
    private List<ListDetails> rank_list;

    public LeaderBoardData(String message, boolean success, List<ListDetails> listDetailses) {
        this.message = message;
        this.success = success;
        this.rank_list = listDetailses;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<ListDetails> getListDetailses() {
        return rank_list;
    }
}
