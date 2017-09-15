package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.HintsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.api.HintsApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data.HintsData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 15/9/17.
 */

public class RetrofitHintsProvider implements HintsProvider{

    private HintsApi hintsApi;
    private Call<HintsData> hintsDataCall;
    private Retrofit retrofit;

    public RetrofitHintsProvider() {
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        hintsApi = retrofit.create(HintsApi.class);
    }


    @Override
    public void requestHints(String acces_token, final HintsCallBack hintsCallBack) {
        hintsDataCall= hintsApi.requestHints(acces_token);
        hintsDataCall.enqueue(new Callback<HintsData>() {
            @Override
            public void onResponse(Call<HintsData> call, Response<HintsData> response) {
                try {
                    hintsCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<HintsData> call, Throwable t) {
                t.printStackTrace();
                hintsCallBack.onFailure("No Internet Connection");
            }
        });
    }
}
