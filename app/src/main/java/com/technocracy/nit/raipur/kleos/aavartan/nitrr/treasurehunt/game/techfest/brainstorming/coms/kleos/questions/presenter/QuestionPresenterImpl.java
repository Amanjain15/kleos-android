package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.QuestionRequestCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.QuestionResponseCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.QuestionProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionResponseData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view.QuestionResponseView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view.QuestionView;

/**
 * Created by aman on 12/9/17.
 */

public class QuestionPresenterImpl implements  QuestionPresenter {

    private QuestionView questionView;
    private QuestionProvider questionProvider;
    private QuestionResponseView questionResponseView;

    public QuestionPresenterImpl(QuestionView questionView, QuestionProvider questionProvider) {
        this.questionView = questionView;
        this.questionProvider = questionProvider;
    }

    public QuestionPresenterImpl(QuestionProvider questionProvider, QuestionResponseView questionResponseView) {
        this.questionProvider = questionProvider;
        this.questionResponseView = questionResponseView;
    }

    @Override
    public void requestQuestion(String access_token) {
        questionView.showLoading(true);
        questionProvider.requestQuestions(access_token, new QuestionRequestCallBack() {
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
        questionResponseView.showLoading(true);
        questionProvider.responseQuestion(access_token,question_no,answer,new QuestionResponseCallBack() {
            @Override
            public void onSuccess(QuestionResponseData questionData) {
                try {
                    if (questionData.isSuccess()){
                        questionResponseView.showLoading(false);
                        questionResponseView.onRightAnswer();

                    }else {
                        questionResponseView.showLoading(false);
                        questionResponseView.showMessage(questionData.getMessage());
                    }
                }catch (NullPointerException e){
                    e.printStackTrace();
                    questionResponseView.showMessage("Success Null");
                    questionResponseView.showLoading(false);
                }
            }

            @Override
            public void onFailure(String s) {
                questionResponseView.showLoading(false);
                questionResponseView.showMessage(s);
            }
        });
    }
}
