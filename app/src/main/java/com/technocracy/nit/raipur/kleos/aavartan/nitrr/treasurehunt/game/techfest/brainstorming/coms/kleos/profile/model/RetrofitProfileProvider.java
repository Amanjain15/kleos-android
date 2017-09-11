package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Urls;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.EditProfileCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.ProfileCallBack;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.api.ProfileRequestApi;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.EditProfileData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 11/9/17.
 */

public class RetrofitProfileProvider implements  ProfileRequestProvider {

    private ProfileRequestApi profileRequestApi;
    private Call <ProfileRequestData> profileRequestDataCall;
    private Call <EditProfileData> editProfileDataCall;
    private Retrofit retrofit;


    public RetrofitProfileProvider() {
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        profileRequestApi = retrofit.create(ProfileRequestApi.class);

    }

    @Override
    public void requestProfile(String acces_token, final ProfileCallBack profileCallBack) {

        profileRequestDataCall= profileRequestApi.requestProfile(acces_token);

        profileRequestDataCall.enqueue(new Callback<ProfileRequestData>() {
            @Override
            public void onResponse(Call<ProfileRequestData> call, Response<ProfileRequestData> response) {
                try {
                    profileCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ProfileRequestData> call, Throwable t) {
                t.printStackTrace();
                profileCallBack.onFailure("No Internet Connection");
            }
        });
    }

    @Override
    public void editProfile(String access_token, String name, String college, String email,
                            final EditProfileCallBack editProfileCallBack) {
        editProfileDataCall= profileRequestApi.requestEditProfile(access_token,name,college,email);
        editProfileDataCall.enqueue(new Callback<EditProfileData>() {
            @Override
            public void onResponse(Call<EditProfileData> call, Response<EditProfileData> response) {
                try {
                    editProfileCallBack.onSuccess(response.body());
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<EditProfileData> call, Throwable t) {
                t.printStackTrace();
                editProfileCallBack.onFailure("No Internet Connection");
            }
        });
    }
}
