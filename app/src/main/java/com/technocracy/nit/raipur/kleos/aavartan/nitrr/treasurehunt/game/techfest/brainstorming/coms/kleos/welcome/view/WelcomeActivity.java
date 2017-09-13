package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.view.LoginActivity;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.RetrofitWelcomeProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeImageDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.presenter.WelcomePresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.presenter.WelcomePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {

    private ViewPager viewPager;
    private WelcomeViewPagerAdapter welcomeViewPagerAdapter;
    private WelcomePresenter welcomePresenter;
    private TabLayout tabLayout;
    private Toaster toaster;
    private SharedPrefs sharedPreferences;

    @BindView(R.id.button_login)
    Button button_login;
    @BindView(R.id.button_sign_up)
    Button button_sign_up;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.button_layout)
    LinearLayout linearLayout;
    public static WelcomeActivity welcomeActivity;
    private String WelcomeActivityTag= "WelcomeScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeActivity=this;
        ButterKnife.bind(welcomeActivity);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        initialise();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(WelcomeActivityTag,"Login");
                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(WelcomeActivityTag,"SignUp");
//                Intent i = new Intent(WelcomeActivity.this, SignUpActivity.class);
//                startActivity(i);
//                finish();

            }
        });



    }

    private void initialise() {
        sharedPreferences = new SharedPrefs(welcomeActivity);
        welcomeViewPagerAdapter = new WelcomeViewPagerAdapter(welcomeActivity);
        welcomePresenter = new WelcomePresenterImpl(this, new RetrofitWelcomeProvider());
//        welcomeScreenPresenter = new WelcomeScreenPresenterImpl(welcomeScreenActivity, new MockWelcomeProvider());
        viewPager.setAdapter(welcomeViewPagerAdapter);
        welcomePresenter.getWelcomeData();
    }

    @Override
    public void showMessage(String error) {
        Toaster.showShortMessage(welcomeActivity,error);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setData(final List<WelcomeImageDetails> welcomeImageDetails) {
//        sharedPreferences.setFirstTimeLaunch(false);
        welcomeViewPagerAdapter.setImageList(welcomeImageDetails);
        welcomeViewPagerAdapter.notifyDataSetChanged();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == welcomeImageDetails.size()-1){
                    linearLayout.setVisibility(View.VISIBLE);
                    tabLayout.setVisibility(View.INVISIBLE);
                }else {
                    linearLayout.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.VISIBLE);
                }
                if(welcomeImageDetails.size()==1){
                    linearLayout.setVisibility(View.VISIBLE);
                    tabLayout.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
