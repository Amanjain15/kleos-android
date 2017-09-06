package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.api;



import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.data.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 5/9/17.
 */

public interface LoginApi {
    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginData> requestLogin(@Field(Keys.KEY_MOBILE) String mobile,
                                 @Field(Keys.KEY_PASSWORD) String password);

}
