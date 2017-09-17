package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SponsorActivity extends AppCompatActivity {

    private String spons_name,spons_image, spons_content,spons_url;
    private ImageLoader imageLoader;
    private static Context context;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.web_url)
    Button web_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor_avtivity);

        ButterKnife.bind(this);
        if (getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            spons_name = bundle.getString(Keys.KEY_SPONSOR_NAME);
            spons_content = bundle.getString(Keys.KEY_SPONSOR_CONTENT);
            spons_image=bundle.getString(Keys.KEY_QUESTION_IMAGE);
            spons_url=bundle.getString(Keys.KEY_SPONSOR_WEB_URL);
        }
        initialize();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle(spons_name);
        name.setText(spons_name);
        content.setText(spons_content);
        imageLoader.loadImage(spons_image,imageView,imageProgressBar);
        context=this;
        web_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(spons_url);
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
                builder.setSecondaryToolbarColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimaryDark));
                builder.setExitAnimations(getApplicationContext(), android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(context, uri);
            }
        });

    }

    private void initialize() {
        imageLoader = new GlideImageLoader(this);
    }
}
