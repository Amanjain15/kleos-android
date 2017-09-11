package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.data.StoryLineData;

/**
 * Created by aman on 6/9/17.
 */

public interface StorylineCallBack {
    void onSuccess(StoryLineData storyLineData);

    void onFailure(String s);
}

