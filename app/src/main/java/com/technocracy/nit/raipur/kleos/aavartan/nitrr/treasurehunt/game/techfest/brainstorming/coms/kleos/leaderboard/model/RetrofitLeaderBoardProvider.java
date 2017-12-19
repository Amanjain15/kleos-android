package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.LeaderBoardCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.api.LeaderBoardApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data.LeaderBoardData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 19/9/17.
 */

public class RetrofitLeaderBoardProvider implements LeaderBoardProvider {

    private LeaderBoardApi leaderBoardApi;
    private Call<LeaderBoardData> leaderBoardDataCall;
    private Retrofit retrofit;


    public RetrofitLeaderBoardProvider() {
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        leaderBoardApi = retrofit.create(LeaderBoardApi.class);
    }

    @Override
    public void requestBoard(String access_token, final LeaderBoardCallBack leaderBoardCallBack) {
        leaderBoardDataCall = leaderBoardApi.requestBoard(access_token);
        leaderBoardDataCall.enqueue(new Callback<LeaderBoardData>() {
            @Override
            public void onResponse(Call<LeaderBoardData> call, Response<LeaderBoardData> response) {
                try {
                    leaderBoardCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LeaderBoardData> call, Throwable t) {
                t.printStackTrace();
                leaderBoardCallBack.onFailure("No Internet Connection.");
            }
        });
    }
}
