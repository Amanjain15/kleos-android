package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.api.HomeTabsApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.SponserCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.api.SponserApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 6/9/17.
 */

public class RetrofitSponserProvider implements SponserProvider {
    SponserApi sponserApi;
    Retrofit retrofit;
    public RetrofitSponserProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        sponserApi = retrofit.create(SponserApi.class);


    }

    @Override
    public void sponsers(String access_token, final SponserCallBack sponserCallBack) {
        Call<SponserData>call=sponserApi.requestSponsers(access_token);
        call.enqueue(new Callback<SponserData>() {
            @Override
            public void onResponse(Call<SponserData> call, Response<SponserData> response) {
                sponserCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SponserData> call, Throwable t) {

                sponserCallBack.onFailure();
                t.printStackTrace();
            }
        });
    }
}
