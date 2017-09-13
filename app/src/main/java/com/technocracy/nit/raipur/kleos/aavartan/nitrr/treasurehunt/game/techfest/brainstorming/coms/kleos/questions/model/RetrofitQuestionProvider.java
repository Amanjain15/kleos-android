package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.QuestionRequestCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.api.QuestionRequestApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;

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

public class RetrofitQuestionProvider implements QuestionProvider{

    private QuestionRequestApi questionRequestApi;
    private Call<QuestionData> questionDataCall;
    private Retrofit retrofit;

    public RetrofitQuestionProvider() {
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        questionRequestApi = retrofit.create(QuestionRequestApi.class);
    }

    @Override
    public void requestQuestions(String access_token, final QuestionRequestCallBack questionRequestCallBack) {
        questionDataCall = questionRequestApi.requestQuestion(access_token);
        questionDataCall.enqueue(new Callback<QuestionData>() {
            @Override
            public void onResponse(Call<QuestionData> call, Response<QuestionData> response) {
                try {
                    questionRequestCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<QuestionData> call, Throwable t) {
                t.printStackTrace();
                questionRequestCallBack.onFailure("No Internet Connection");
            }
        });

    }
}
