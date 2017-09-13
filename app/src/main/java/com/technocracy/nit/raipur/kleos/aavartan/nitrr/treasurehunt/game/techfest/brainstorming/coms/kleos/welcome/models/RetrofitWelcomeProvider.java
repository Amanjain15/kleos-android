package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.WelcomeScreenCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.api.WelcomeApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 1/9/17.
 */

public class RetrofitWelcomeProvider implements WelcomeProvider {

    private static final String TAG = "RetrofitWelcomeScreenProvider";
    private WelcomeApi welcomeApi;
    private Call<WelcomeData> welcomeScreenDataCall;

    public RetrofitWelcomeProvider() {
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

        this.welcomeApi = retrofit.create(WelcomeApi.class);
    }


    @Override
    public void getWelcomeData(final WelcomeScreenCallBack welcomeScreenCallback) {
        welcomeScreenDataCall = welcomeApi.getWelcomeData();

        welcomeScreenDataCall.enqueue(new Callback<WelcomeData>() {
            @Override
            public void onResponse(Call<WelcomeData> call, Response<WelcomeData> response) {
                try {
                    welcomeScreenCallback.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<WelcomeData> call, Throwable t) {
                t.printStackTrace();
                welcomeScreenCallback.onFailure("Unable to Load");
            }
        });

    }
}
