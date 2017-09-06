package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by aman on 30/08/17.
 */

public class MyApplication extends Application {

    private static Context context;
    private static String fcm_token;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
		FirebaseApp.initializeApp(context);

//        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/comfortaa.ttf");
//        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/homemade.ttf");
//        FontsOverride.setDefaultFont(this, "SERIF", "fonts/nunito.ttf");
//        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/patrick_hand.ttf");


    }

    public static String getFcm_token() {
        fcm_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Fcm is "+fcm_token);
        return fcm_token;
    }

    public static Context getContext() {
        return context;
    }


}
