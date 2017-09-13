package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;

/**
 * Created by aman on 12/9/17.
 */

public interface QuestionView {

    void setData(QuestionData questionData);
    void showLoading(boolean show);
    void showMessage(String message);

    void enableEdit(boolean edit);
    void enableSave(boolean save);

    void onEdit();
}
