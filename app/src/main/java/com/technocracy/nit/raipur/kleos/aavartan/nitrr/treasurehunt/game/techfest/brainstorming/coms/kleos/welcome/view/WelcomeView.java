package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeImageDetails;

import java.util.List;

/**
 * Created by aman on 1/9/17.
 */

public interface WelcomeView {
    void showMessage(String error);

    void showProgressBar(boolean show);

    void setData(List<WelcomeImageDetails> welcomeImageDetails);
}
