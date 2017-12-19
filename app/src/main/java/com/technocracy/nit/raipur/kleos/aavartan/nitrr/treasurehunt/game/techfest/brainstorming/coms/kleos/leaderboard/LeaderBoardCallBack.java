package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data.LeaderBoardData;

/**
 * Created by aman on 19/9/17.
 */

public interface LeaderBoardCallBack {
    void onSuccess(LeaderBoardData leaderBoardData);

    void onFailure(String s);
}
