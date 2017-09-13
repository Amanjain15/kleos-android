package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen;

import android.content.pm.PackageManager;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.models.data.SplashScreenData;

/**
 * Created by aman on 23/8/17.
 */

public interface SplashScreenCallBack {

    void onSuccess(SplashScreenData splashScreenData) throws PackageManager.NameNotFoundException;

    void onFailure(String error);
}
