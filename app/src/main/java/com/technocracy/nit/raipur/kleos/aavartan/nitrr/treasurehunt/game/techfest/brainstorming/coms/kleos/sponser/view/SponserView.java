package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;

/**
 * Created by aman on 6/9/17.
 */

public interface SponserView {

    void setSponsers(SponserData sponserData);
    void showLoading(boolean show);
    void showMessage(String message);
}
