package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.view;

import android.content.pm.PackageManager;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.models.data.SplashScreenData;

/**
 * Created by aman on 1/9/17.
 */

public interface SplashScreenView {

    void showMessage(String message);

    void showProgressBar(boolean show);

    void onVersionReceived(SplashScreenData splashScreenData) throws PackageManager.NameNotFoundException;

    void onFailed();

    void showDialog(String message);
}
