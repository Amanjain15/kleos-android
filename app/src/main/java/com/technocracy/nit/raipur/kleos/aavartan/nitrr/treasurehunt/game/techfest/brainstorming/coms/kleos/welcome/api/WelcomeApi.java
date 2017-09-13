package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 1/9/17.
 */

public interface WelcomeApi {

    @GET(Urls.REQUEST_WELCOME)
    Call<WelcomeData> getWelcomeData();
}
