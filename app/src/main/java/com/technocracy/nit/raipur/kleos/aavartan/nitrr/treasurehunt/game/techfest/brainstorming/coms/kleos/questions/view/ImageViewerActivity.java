package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;

import com.alexvasilkov.gestures.Settings;
import com.alexvasilkov.gestures.views.GestureImageView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewerActivity extends AppCompatActivity {

    GestureImageView imageView;
    private Context context;
    private ImageLoader imageLoader;
    private String url,name;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        context = this;
        ButterKnife.bind(this);
        imageLoader = new GlideImageLoader(this);
        if (getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            name = bundle.getString(Keys.KEY_QUESTION_NAME);
            url=bundle.getString(Keys.KEY_QUESTION_IMAGE);
        }
        toolbar.setTitle(name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);
        imageView = (GestureImageView)findViewById(R.id.imageView);
        imageView.getController().getSettings()
                .setMaxZoom(5f)
                .setPanEnabled(true)
                .setZoomEnabled(true)
                .setDoubleTapEnabled(true)
                .setRotationEnabled(false)
                .setRestrictRotation(false)
                .setOverscrollDistance(10f, 10f)
                .setOverzoomFactor(3f)
                .setFitMethod(Settings.Fit.INSIDE)
                //.setFillViewport(true)
                //    .setFitMethod(Settings.Fit.INSIDE)
                .setGravity(Gravity.CENTER);

        imageLoader.loadImage(url, imageView,progressBar);

    }

}
