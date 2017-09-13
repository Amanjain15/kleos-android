package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.EditProfileData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 11/9/17.
 */

public interface ProfileRequestApi {

    @GET(Urls.REQUEST_PROFILE)
    Call<ProfileRequestData> requestProfile(@Query(Keys.KEY_ACCESS_TOKEN) String access_token);

    @FormUrlEncoded
    @POST(Urls.REQUEST_PROFILE)
    Call<EditProfileData> requestEditProfile(@Field(Keys.KEY_ACCESS_TOKEN) String access_token,
                                             @Field(Keys.KEY_NAME) String name,
                                             @Field(Keys.KEY_COLLEGE) String college,
                                             @Field(Keys.KEY_EMAIL) String email
                                             );
}
