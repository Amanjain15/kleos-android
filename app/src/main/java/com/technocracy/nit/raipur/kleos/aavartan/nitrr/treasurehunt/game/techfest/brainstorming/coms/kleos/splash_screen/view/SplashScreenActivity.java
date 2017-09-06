package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.Home;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.crashlytics.android.Crashlytics;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.view.LoginActivity;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.models.RetrofitSplashScreenProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.models.data.SplashScreenData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.presenter.SplashScreenPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.splash_screen.presenter.SplashScreenPresenterImpl;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view.WelcomeActivity;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view.WelcomeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    private Context context;
    private ImageLoader imageLoader;
    private SharedPrefs sharedPrefs;
    private SplashScreenPresenter splashScreenPresenter;
    private Handler handler;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.logo)
    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        initialise();
        Glide.with(this).load(R.drawable.ic_logo).into(logo);
        splashScreenPresenter.requestSplash();
    }

    private void initialise(){
        context=this;
        sharedPrefs= new SharedPrefs(context);
        imageLoader = new GlideImageLoader(context);
        splashScreenPresenter = new SplashScreenPresenterImpl(this,
                                new RetrofitSplashScreenProvider());

    }

    @Override
    public void showMessage(String message) {
        Toaster.showShortMessage(context,message);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onVersionReceived(SplashScreenData splashScreenData) throws PackageManager.NameNotFoundException {

        if (getPackageManager().getPackageInfo(getPackageName(), 0).versionCode <
                splashScreenData.getVersion() && !splashScreenData.isCompulsory_update())
        {
            final AlertDialog ad = new AlertDialog.Builder(this)
                    .create();
            ad.setCancelable(false);
            ad.setTitle("App Update Available");
            Log.d("SPLASH1---", "No");
            ad.setMessage("Please update the app for better experience");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();
                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }

                    finish();
                }
            });
            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "Not Now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();

                    if (!sharedPrefs.isFirstTimeLaunch()) {
                        if (sharedPrefs.isLoggedIn()) {
                            startActivity(new Intent(SplashScreenActivity.this, Home.class));
                            finish();
                        } else {
                            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                            finish();
                        }

                    } else {
                        startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
                        finish();
                    }

                }
            });
            ad.show();


        }
        else if (getPackageManager().getPackageInfo(getPackageName(), 0).versionCode <
                splashScreenData.getVersion() && splashScreenData.isCompulsory_update()) {
            Log.d("SPLASH2---","No");

            final AlertDialog ad = new AlertDialog.Builder(this)

                    .create();
            ad.setCancelable(false);
            ad.setTitle("App Update Available");
            ad.setMessage("This is a compulsory Update . Please Update the app to enjoy the game");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();
                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }

                    finish();
                }
            });
            ad.show();
        }
        else
        {
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (!sharedPrefs.isFirstTimeLaunch()) {
                        if (sharedPrefs.isLoggedIn()) {
                            startActivity(new Intent(SplashScreenActivity.this, Home.class));
                            finish();
                        } else {
                            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                            finish();
                        }

                    } else {
                        Log.d("Splash---", "Intent Welcome");
                        startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
                        finish();
                    }

                }
            }, 300);

        }
    }

    @Override
    public void onFailed() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!sharedPrefs.isFirstTimeLaunch()) {
                    if (sharedPrefs.isLoggedIn()) {
                        startActivity(new Intent(SplashScreenActivity.this, Home.class));
                        finish();
                    } else {
                        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                        finish();
                    }
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
                    finish();
                }

            }
        }, 300);

    }

    @Override
    public void showDialog(String message) {
        final AlertDialog ad = new AlertDialog.Builder(this)
                .create();
        ad.setCancelable(false);
        ad.setTitle("No Internet Connection");
        ad.setMessage("Please connect to internet to use our app");
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                splashScreenPresenter.requestSplash();

            }
        });
        ad.show();
    }
}
