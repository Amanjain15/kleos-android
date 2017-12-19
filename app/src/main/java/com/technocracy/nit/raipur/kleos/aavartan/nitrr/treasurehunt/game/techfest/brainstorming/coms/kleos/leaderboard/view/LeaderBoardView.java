package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data.LeaderBoardData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;

/**
 * Created by aman on 19/9/17.
 */

public interface LeaderBoardView {
    void setData(LeaderBoardData leaderBoardData);
    void showLoading(boolean show);
    void showMessage(String message);
}
