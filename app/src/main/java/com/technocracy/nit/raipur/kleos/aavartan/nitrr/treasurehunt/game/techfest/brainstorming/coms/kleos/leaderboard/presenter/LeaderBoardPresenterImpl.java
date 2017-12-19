package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.presenter;

import android.util.Log;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.LeaderBoardCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.LeaderBoardProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data.LeaderBoardData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.view.LeaderBoardView;

/**
 * Created by aman on 19/9/17.
 */

public class LeaderBoardPresenterImpl implements LeaderBoardPresenter {
    private LeaderBoardView leaderBoardView;
    private LeaderBoardProvider leaderBoardProvider;

    public LeaderBoardPresenterImpl(LeaderBoardView leaderBoardView,
                                    LeaderBoardProvider leaderBoardProvider) {
        this.leaderBoardView = leaderBoardView;
        this.leaderBoardProvider = leaderBoardProvider;
    }

    @Override
    public void requestBoard(String access_token) {
        leaderBoardView.showLoading(true);
        leaderBoardProvider.requestBoard(access_token, new LeaderBoardCallBack() {
            @Override
            public void onSuccess(LeaderBoardData leaderBoardData) {
                try {
                    if (leaderBoardData.isSuccess()){
                        leaderBoardView.showLoading(false);
                        leaderBoardView.setData(leaderBoardData);
                        Log.d("LeaderBoard",leaderBoardData.getListDetailses().size()+"List Size");
                    }else{
                        leaderBoardView.showLoading(false);
                        leaderBoardView.showMessage(leaderBoardData.getMessage());
                    }

                }catch (NullPointerException e){
                    leaderBoardView.showLoading(false);
                    leaderBoardView.showMessage(leaderBoardData.getMessage());
                }
            }

            @Override
            public void onFailure(String s) {
                leaderBoardView.showLoading(false);
                leaderBoardView.showMessage(s);
            }
        });

    }
}
