package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data.AboutUsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface AboutUsApi {
    @GET(Urls.ABOUT_US)
    Call<AboutUsData> getdata(@Query("access_token")String access_token);
}