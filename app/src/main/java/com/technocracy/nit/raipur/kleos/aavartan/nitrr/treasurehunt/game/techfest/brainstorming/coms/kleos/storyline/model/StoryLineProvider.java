package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.StorylineCallBack;

/**
 * Created by aman on 12/9/17.
 */

public interface StoryLineProvider {
    void requestStory(String access_token, StorylineCallBack storylineCallBack);
}
