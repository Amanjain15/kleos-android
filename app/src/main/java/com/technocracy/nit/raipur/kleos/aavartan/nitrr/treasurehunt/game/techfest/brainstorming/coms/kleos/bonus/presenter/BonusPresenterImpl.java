package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.BonusCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.BonusResponseCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.BonusProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionResponseData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.view.BonusView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionData;

/**
 * Created by aman on 14/9/17.
 */

public class BonusPresenterImpl implements BonusPresenter {

    private BonusView questionView;
    private BonusProvider questionProvider;

    public BonusPresenterImpl(BonusView questionView, BonusProvider questionProvider) {
        this.questionView = questionView;
        this.questionProvider = questionProvider;
    }

    @Override
    public void requestQuestion(String access_token) {
        questionView.showLoading(true);
        questionProvider.requestQuestions(access_token, new BonusCallBack() {
            @Override
            public void onSuccess(QuestionData questionData) {
                try {
                    if (questionData.isSuccess()){
                        questionView.showLoading(false);
                        questionView.setData(questionData);

                    }else {
                        questionView.showLoading(false);
                        questionView.showMessage(questionData.getMessage());
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                    questionView.showMessage("Success Null");
                    questionView.showLoading(false);
                }
            }

            @Override
            public void onFailure(String s) {
                questionView.showLoading(false);
                questionView.showMessage(s);
            }
        });
    }

    @Override
    public void responseQuestion(String access_token, String question_no, String answer) {
        questionView.showLoading(true);
        questionProvider.responseQuestion(access_token,question_no,answer,new BonusResponseCallBack() {
            @Override
            public void onSuccess(QuestionResponseData questionData) {
                try {
                    if (questionData.isSuccess()){
                        questionView.showLoading(false);
                        questionView.onRightAnswer();

                    }else {
                        questionView.showLoading(false);
                        questionView.showMessage(questionData.getMessage());
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                    questionView.showMessage("Success Null");
                    questionView.showLoading(false);
                }
            }

            @Override
            public void onFailure(String s) {
                questionView.showLoading(false);
                questionView.showMessage(s);
            }
        });
    }

}
