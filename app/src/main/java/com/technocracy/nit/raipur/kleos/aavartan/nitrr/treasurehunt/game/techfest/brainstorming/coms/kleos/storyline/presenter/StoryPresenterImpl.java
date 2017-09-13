package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.StorylineCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.StoryLineProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.data.StoryLineData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.view.StoryLineView;

/**
 * Created by aman on 12/9/17.
 */

public class StoryPresenterImpl implements StoryLinePresenter{
    private StoryLineView storyLineView;
    private StoryLineProvider storyLineProvider;

    public StoryPresenterImpl(StoryLineView storyLineView, StoryLineProvider storyLineProvider) {

        this.storyLineView = storyLineView;
        this.storyLineProvider = storyLineProvider;
    }


    @Override
    public void requestStory(String access_token) {
        storyLineView.showLoading(true);
        storyLineProvider.requestStory(access_token, new StorylineCallBack() {
            @Override
            public void onSuccess(StoryLineData storyLineData) {
                try{
                    if (storyLineData.isSuccess())
                    {
                        storyLineView.showLoading(false);
                        storyLineView.setData(storyLineData);
                    }
                    else{
                        storyLineView.showMessage(storyLineData.getMessage());
                        storyLineView.showLoading(false);
                    }
                }
                catch (NullPointerException e){

                    e.printStackTrace();
                    storyLineView.showMessage("Success Null in Profile");
                }
            }

            @Override
            public void onFailure(String s) {
                storyLineView.showMessage(s);
                storyLineView.showLoading(false);
            }
        });
    }
}
