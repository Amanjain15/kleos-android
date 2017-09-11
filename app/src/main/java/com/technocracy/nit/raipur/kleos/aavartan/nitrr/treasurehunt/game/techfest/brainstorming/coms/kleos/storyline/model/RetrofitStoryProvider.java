package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.StorylineCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.api.StoryLineApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.model.data.StoryLineData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 12/9/17.
 */

public class RetrofitStoryProvider implements  StoryLineProvider{

    private StoryLineApi storyLineApi;
    private Call <StoryLineData> storyLineDataCall;
    private Retrofit retrofit;

    public RetrofitStoryProvider() {
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        storyLineApi = retrofit.create(StoryLineApi.class);
    }

    @Override
    public void requestStory(String access_token, final StorylineCallBack storylineCallBack) {
        storyLineDataCall = storyLineApi.requestStory(access_token);

        storyLineDataCall.enqueue(new Callback<StoryLineData>() {
            @Override
            public void onResponse(Call<StoryLineData> call, Response<StoryLineData> response) {
                try {
                    storylineCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<StoryLineData> call, Throwable t) {
                t.printStackTrace();
                storylineCallBack.onFailure("No Internet Connection");
            }
        });
    }
}
