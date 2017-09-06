package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OnOtpResendResponse;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.OtpCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.UpdateDetailsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.VerifyOtpCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.api.SignUpApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.ResendOtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 6/9/17.
 */

public class RetrofitSignUpProvider implements SignUpProvider {

    private static final String TAG = "RetrofitLoginScreenProvider";
    private SignUpApi signUpApi;
    private Call<OtpData> otpDataCall;
    private Call<SignUpRequestData> verifyOtpDataCall;
    private Call<ResendOtpData> resendOtpDataCall;
    private Call<UpdateDetailsData> updateDetailsDataCall;

    public RetrofitSignUpProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.signUpApi = retrofit.create(SignUpApi.class);
    }

    @Override
    public void requestOtp(String name, String mobile, String email, final OtpCallBack otpCallBack) {
        otpDataCall = signUpApi.requestOtp(name,mobile,email);
        otpDataCall.enqueue(new Callback<OtpData>() {
            @Override
            public void onResponse(Call<OtpData> call, Response<OtpData> response) {
                try {
                    otpCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<OtpData> call, Throwable t) {
                t.printStackTrace();
                otpCallBack.onFailure("No Internet Connection");
            }
        });

    }

    @Override
    public void verifyOtp(String temp_access_token, String otp, final VerifyOtpCallBack verifyOtpCallBack) {
        verifyOtpDataCall= signUpApi.verifyOtp(temp_access_token,otp);
        verifyOtpDataCall.enqueue(new Callback<SignUpRequestData>() {
            @Override
            public void onResponse(Call<SignUpRequestData> call, Response<SignUpRequestData> response) {
                try {
                    verifyOtpCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SignUpRequestData> call, Throwable t) {
                t.printStackTrace();
                verifyOtpCallBack.onFailure("No Internet Connection");
            }
        });
    }

    @Override
    public void resendOtp(String temp_access_token, final OnOtpResendResponse onOtpResendResponse) {
        resendOtpDataCall= signUpApi.requestOtpResend(temp_access_token);
        resendOtpDataCall.enqueue(new Callback<ResendOtpData>() {
            @Override
            public void onResponse(Call<ResendOtpData> call, Response<ResendOtpData> response) {
                try {
                    onOtpResendResponse.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResendOtpData> call, Throwable t) {
                t.printStackTrace();
                onOtpResendResponse.onFailure("No Internet Connection");
            }
        });
    }

    @Override
    public void updateDetails(String access_token, String name, String college, String password,
                              final UpdateDetailsCallBack updateDetailsCallBack) {
        updateDetailsDataCall= signUpApi.updateDetails(access_token,name,college,password);
        updateDetailsDataCall.enqueue(new Callback<UpdateDetailsData>() {
            @Override
            public void onResponse(Call<UpdateDetailsData> call, Response<UpdateDetailsData> response) {
                try {
                    updateDetailsCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UpdateDetailsData> call, Throwable t) {
                t.printStackTrace();
                updateDetailsCallBack.onFailure("No Internet Connection");
            }
        });

    }
}
