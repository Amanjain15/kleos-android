package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.HomeCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.api.HomeTabsApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;

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

public class RetrofitHomeTabsProvider implements HomeTabsProvider {
    private HomeTabsApi homeTabsApi;
    Retrofit retrofit;

    public RetrofitHomeTabsProvider() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        homeTabsApi = retrofit.create(HomeTabsApi.class);


    }

    @Override
    public void getTabs(String access_token, final HomeCallBack homeCallBack) {
        Call<TabsData>call=homeTabsApi.requestTabs(access_token);
        call.enqueue(new Callback<TabsData>() {
            @Override
            public void onResponse(Call<TabsData> call, Response<TabsData> response) {
                homeCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TabsData> call, Throwable t) {
                         homeCallBack.onFailure();
                t.printStackTrace();
            }
        });


    }
}
