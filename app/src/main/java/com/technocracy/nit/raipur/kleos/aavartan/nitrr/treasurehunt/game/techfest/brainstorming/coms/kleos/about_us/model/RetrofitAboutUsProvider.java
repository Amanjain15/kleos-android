package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.AboutUsCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.api.AboutUsApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.model.data.AboutUsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAboutUsProvider implements AboutUsProvider {

    private AboutUsApi aboutUsApi;
    Call<AboutUsData> aboutUsData;

    public RetrofitAboutUsProvider() {
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

        this.aboutUsApi = retrofit.create(AboutUsApi.class);

    }

    @Override
    public void getData(String access_token, final AboutUsCallBack aboutUsCallBack) {

        aboutUsData=aboutUsApi.getdata(access_token);
        aboutUsData.enqueue(new Callback<AboutUsData>() {
            @Override
            public void onResponse(Call<AboutUsData> call, Response<AboutUsData> response) {
                aboutUsCallBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<AboutUsData> call, Throwable t) {
               aboutUsCallBack.onFailure();
                t.printStackTrace();
            }
        });


    }
}