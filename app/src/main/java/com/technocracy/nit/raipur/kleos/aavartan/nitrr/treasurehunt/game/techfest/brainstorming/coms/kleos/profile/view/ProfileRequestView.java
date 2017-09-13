package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;

/**
 * Created by aman on 11/9/17.
 */

public interface ProfileRequestView {

    void setData(ProfileRequestData profileRequestData);
    void showLoading(boolean show);
    void showMessage(String message);

    void enableEdit(boolean edit);
    void enableSave(boolean save);

    void onEdit();
}
