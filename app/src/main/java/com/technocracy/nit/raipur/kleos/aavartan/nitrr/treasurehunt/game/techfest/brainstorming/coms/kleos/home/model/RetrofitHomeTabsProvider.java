package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
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
    private Call<TabsData> tabsDataCall;
    private Retrofit retrofit;

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
    public void getTabs(String access_token,String fcm, final HomeCallBack homeCallBack) {
        tabsDataCall=homeTabsApi.requestTabs(access_token,fcm);
        tabsDataCall.enqueue(new Callback<TabsData>() {
            @Override
            public void onResponse(Call<TabsData> call, Response<TabsData> response) {
                try {
                    homeCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TabsData> call, Throwable t) {
                homeCallBack.onFailure("No Internet Connection");
                t.printStackTrace();
            }
        });


    }
}
