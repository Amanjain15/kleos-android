package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by aman on 30/08/17.
 */

public interface ImageLoader {

    void loadImage(String url, ImageView imageView, ProgressBar progressBar);

    void loadImage1(String image_url, ImageView aah_imageView);
    void load_circular_image(String url, ImageView imageView);
}
