package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.LeaderBoardCallBack;

/**
 * Created by aman on 19/9/17.
 */

public interface LeaderBoardProvider {

    void requestBoard(String access_token , LeaderBoardCallBack leaderBoardCallBack);
}
