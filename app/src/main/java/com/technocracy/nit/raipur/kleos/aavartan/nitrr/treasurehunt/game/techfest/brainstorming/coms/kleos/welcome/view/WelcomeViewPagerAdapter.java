package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.welcome.models.data.WelcomeImageDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 1/9/17.
 */

public class WelcomeViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<WelcomeImageDetails> welcomeImageDetailsList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    private TextView textView;
    private ProgressBar imageProgressBar;
    private ImageView imageView;

    public WelcomeViewPagerAdapter(Context context) {
        this.context = context;
        imageLoader=new GlideImageLoader(context);
        layoutInflater = LayoutInflater.from(context);
    }


    public void setImageList(List<WelcomeImageDetails> welcomeImageDetailsList) {
        this.welcomeImageDetailsList = welcomeImageDetailsList;
        Log.d("WelcomeViewPager",welcomeImageDetailsList.size()+" ");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = layoutInflater.inflate(R.layout.welcome_view_pager_item, container, false);
        container.addView(view);
        WelcomeImageDetails welcomeImageDetails = welcomeImageDetailsList.get(position);
        textView = (TextView) view.findViewById(R.id.tv1);
        imageProgressBar = (ProgressBar) view.findViewById(R.id.imageProgressBar);
        textView.setText(welcomeImageDetails.getMessage());
        Log.d("WelcomeViewPager",welcomeImageDetails.getImage_url()+position+" ");
        imageView = (ImageView) view.findViewById(R.id.img);
        if (welcomeImageDetails.getImage_url().equals(""))
        {
            Glide.with(context).load(R.drawable.ic_logo).into(imageView);
            imageProgressBar.setVisibility(View.GONE);
        }else {
            imageLoader.loadImage(welcomeImageDetails.getImage_url(),imageView,imageProgressBar);
        }
        return view;
    }

    @Override
    public int getCount() {
        return welcomeImageDetailsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
