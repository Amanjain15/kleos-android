package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.ForgotPasswordCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.api.ForgotApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.forgot_password.models.data.ForgotData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;

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

public class RetrofitForgotProvider implements ForgotProvider{
    private static final String TAG = "RetrofitLoginScreenProvider";
    private ForgotApi forgotApi;
    private Call<ForgotData> forgotDataCall;

    public RetrofitForgotProvider() {
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

        this.forgotApi = retrofit.create(ForgotApi.class);
    }


    @Override
    public void requestForgot(String mobile, final ForgotPasswordCallBack forgotPasswordCallBack) {
        forgotDataCall = forgotApi.requestForgot(mobile);
        forgotDataCall.enqueue(new Callback<ForgotData>() {
            @Override
            public void onResponse(Call<ForgotData> call, Response<ForgotData> response) {
                try {
                    forgotPasswordCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ForgotData> call, Throwable t) {
                t.printStackTrace();
                forgotPasswordCallBack.onFailure("No Internet Connection");
            }
        });
    }

    @Override
    public void responseForgot(String mobile, String otp, String password,
                               final ForgotPasswordCallBack forgotPasswordCallBack) {
        forgotDataCall = forgotApi.responseForgot(mobile,otp,password);
        forgotDataCall.enqueue(new Callback<ForgotData>() {
            @Override
            public void onResponse(Call<ForgotData> call, Response<ForgotData> response) {
                try {
                    forgotPasswordCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ForgotData> call, Throwable t) {
                t.printStackTrace();
                forgotPasswordCallBack.onFailure("No Internet Connection");
            }
        });
    }
}
