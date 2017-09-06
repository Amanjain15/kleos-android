package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.api;

/**
 * Created by aman on 6/9/17.
 */
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface HomeTabsApi {
    @GET(Urls.HomeTabsUrl)
    Call<TabsData>requestTabs(String access_token);
}
