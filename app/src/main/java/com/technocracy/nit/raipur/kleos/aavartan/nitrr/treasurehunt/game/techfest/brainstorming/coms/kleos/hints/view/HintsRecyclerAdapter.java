package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.model.data.HintsDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 15/9/17.
 */

public class HintsRecyclerAdapter extends RecyclerView.Adapter<HintsRecyclerAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<HintsDetails> hintsDetailses;
    private ImageLoader imageLoader;
    private HintsFragment hintsFragment;

    public HintsRecyclerAdapter(Context context, HintsFragment hintsFragment) {
        this.context = context;
        this.hintsFragment = hintsFragment;
        layoutInflater=LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);

    }

    public void setHintsData(List<HintsDetails> hintsDetailsList){
        this.hintsDetailses=hintsDetailsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.hint_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HintsDetails hintsDetails= hintsDetailses.get(position);
        if (!(hintsDetails.getQuestion_img().equals("")))
        {
//            imageLoader.load_circular_image(hintsDetails.getQuestion_img(),holder.imageView);
            imageLoader.loadImage(hintsDetails.getQuestion_img(),holder.imageView,holder.progressBar);
        }
        holder.title.setText(hintsDetails.getQuestion_name());
        holder.hint.setText(hintsDetails.getHint());
    }

    @Override
    public int getItemCount() {

        int pos=0;
        try{
            pos=hintsDetailses.size();
        }catch (NullPointerException e){
            pos=0;
        }

        return pos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.imageProgressBar)
        ProgressBar progressBar;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.hint)
        TextView hint;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
