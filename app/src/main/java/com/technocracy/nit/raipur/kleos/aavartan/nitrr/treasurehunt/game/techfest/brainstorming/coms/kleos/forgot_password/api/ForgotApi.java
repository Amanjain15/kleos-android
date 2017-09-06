package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models.data.ForgotData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 6/9/17.
 */

public interface ForgotApi {

    @GET(Urls.REQUEST_FORGOT_PASSWORD)
    Call<ForgotData> requestForgot(@Query(Keys.KEY_MOBILE) String mobile);

    @FormUrlEncoded
    @POST(Urls.REQUEST_FORGOT_PASSWORD)
    Call<ForgotData> responseForgot(@Field(Keys.KEY_MOBILE) String mobile,
                                    @Field(Keys.KEY_OTP) String otp,
                                    @Field(Keys.KEY_PASSWORD) String password
                                    );
}
