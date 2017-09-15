package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.view;


import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data.AboutUsData;

public interface AboutUsView {

    void showLoading(boolean show);
    void showMessage(String message);
    void setData(AboutUsData aboutUsData);
}