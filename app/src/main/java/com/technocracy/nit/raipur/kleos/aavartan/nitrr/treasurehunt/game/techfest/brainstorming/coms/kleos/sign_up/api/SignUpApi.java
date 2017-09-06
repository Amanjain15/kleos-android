package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.api;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.ResendOtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by aman on 6/9/17.
 */

public interface SignUpApi {

    @FormUrlEncoded
    @POST(Urls.REQUEST_SIGN_UP)
    Call<OtpData> requestOtp(   @Field(Keys.KEY_NAME) String name,
                                @Field(Keys.KEY_MOBILE) String mobile,
                                @Field(Keys.KEY_EMAIL) String email
                             );

    @FormUrlEncoded
    @POST(Urls.REQUEST_OTP_VERIFY)
    Call<SignUpRequestData> verifyOtp(@Field(Keys.KEY_TEMP_ACCESS_TOKEN) String temp_access_token,
                                          @Field(Keys.KEY_OTP) String otp);

    @FormUrlEncoded
    @POST(Urls.REQUEST_RESEND_OTP)
    Call<ResendOtpData> requestOtpResend(@Field(Keys.KEY_TEMP_ACCESS_TOKEN) String temp_access_token);

    @FormUrlEncoded
    @POST(Urls.UPDATE_DETAILS)
    Call<UpdateDetailsData> updateDetails(@Field(Keys.KEY_ACCESS_TOKEN) String access_token,
                                          @Field(Keys.KEY_NAME) String name,
                                          @Field(Keys.KEY_COLLEGE) String college,
                                          @Field(Keys.KEY_PASSWORD) String password
                                        );

}
