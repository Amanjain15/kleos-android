package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view.HomeFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view.QuestionDetailsActivity;

import io.fabric.sdk.android.Fabric;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_home);
        setFragment(new HomeFragment(), "Kleos");
    }
    public void setFragment(Fragment fragment, String title) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.commit();
//            getSupportActionBar().setTitle(title);
        }

    }

    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            //     getSupportActionBar().setTitle(title);
        }

    }
    public void openQuestionDetails(String title, String number, String image,
                                String content, boolean answered) {
        Intent questionDetailsActivityIntent = new Intent(this, QuestionDetailsActivity.class);


        Bundle bundle = new Bundle();
        bundle.putString(Keys.KEY_QUESTION_NAME, title);
        bundle.putString(Keys.KEY_QUESTION_IMAGE, image);
        bundle.putString(Keys.KEY_QUESTION_N0, number);
        bundle.putString(Keys.KEY_QUESTION_CONTENT, content);
        bundle.putBoolean(Keys.KEY_ANSWERED, answered);
        questionDetailsActivityIntent.putExtras(bundle);

        startActivity(questionDetailsActivityIntent);

    }
}
