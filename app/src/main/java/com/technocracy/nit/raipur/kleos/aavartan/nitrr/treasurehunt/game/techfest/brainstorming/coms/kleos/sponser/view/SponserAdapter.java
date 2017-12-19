package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.Home;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view.RecyclerAdapter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 6/9/17.
 */

public class SponserAdapter extends RecyclerView.Adapter<SponserAdapter.ViewHolder1> {


    private List<SponserDetails> sponserDetailsList = new ArrayList<>();
    private SponserDetails sponserDetails;
    private LayoutInflater layoutInflater;
    private Context context;
    private SponserFragment sponserFragment;
    private ImageLoader imageLoader;
    private FragmentActivity fragmentActivity;

    public SponserAdapter( Context context, SponserFragment sponserFragment, FragmentActivity fragmentActivity) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.sponserFragment = sponserFragment;
        this.imageLoader=new GlideImageLoader(context);
        this.fragmentActivity =fragmentActivity;
    }

    public void setSpons(List<SponserDetails> sponserDetailses)
    {
        this.sponserDetailsList=sponserDetailses;
        Log.d("Sponsor",""+sponserDetailsList.size());
    }


    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate( R.layout.sponser_item,parent,false);
        return new ViewHolder1(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder1 holder, final int position) {
        sponserDetails = sponserDetailsList.get(position);
        holder.name.setText(sponserDetails.getName());
     //  imageLoader.loadImage(sponserDetails.getImage_url(), viewHolder.image, viewHolder.image_progress_bar);
        imageLoader.loadImage(sponserDetails.getImage_url(),holder.image,holder.image_progress_bar);
        Log.d("Sponsor____",sponserDetails.getName()+" "+sponserDetails.getImage_url());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SponsorsRecycler",sponserDetails.getName()+" "+
                        sponserDetails.getImage_url()+" "+
                        sponserDetails.getContent()+" "+
                        sponserDetails.getWeb_url()+" "+position);
                SponserDetails sponserDetails = sponserDetailsList.get(position);
                ((Home)context).openSponsorDetails(

                        sponserDetails.getName(),
                        sponserDetails.getImage_url(),
                        sponserDetails.getContent(),
                        sponserDetails.getWeb_url()
                        );
            }
        });
    }

    @Override
    public int getItemCount() {
        return sponserDetailsList.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.sponsImage)
        ImageView image;
        @BindView(R.id.sponsProgressBar)
        ProgressBar image_progress_bar;
        @BindView(R.id.spons_name)
        TextView name;
        @BindView(R.id.detailsLayout)
        RelativeLayout layout;


        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
