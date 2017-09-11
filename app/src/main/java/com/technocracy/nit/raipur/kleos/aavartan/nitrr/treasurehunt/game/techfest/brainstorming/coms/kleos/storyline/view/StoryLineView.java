package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.data.StoryLineData;

/**
 * Created by aman on 12/9/17.
 */

public interface StoryLineView {
    void setData(StoryLineData storyLineData);
    void showLoading(boolean show);
    void showMessage(String message);
}
