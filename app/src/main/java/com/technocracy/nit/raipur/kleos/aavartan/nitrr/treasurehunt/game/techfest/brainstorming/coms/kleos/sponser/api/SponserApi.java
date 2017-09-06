package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aman on 6/9/17.
 */

public interface SponserApi {
    @GET(Urls.SUB_URL_SPONSER)
    Call<SponserData> requestSponsers(String access_token);
}
