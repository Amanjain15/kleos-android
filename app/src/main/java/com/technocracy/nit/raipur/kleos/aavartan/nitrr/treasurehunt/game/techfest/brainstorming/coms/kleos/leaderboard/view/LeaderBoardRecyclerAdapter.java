package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.model.data.ListDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 19/9/17.
 */

public class LeaderBoardRecyclerAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private LeaderBoardFragment leaderBoardFragment;
    private List<ListDetails> listDetailses;

    public LeaderBoardRecyclerAdapter(Context context, LeaderBoardFragment leaderBoardFragment) {
        this.context = context;
        this.leaderBoardFragment = leaderBoardFragment;
        layoutInflater= LayoutInflater.from(context);

    }

    void setItem( List<ListDetails> listDetailsList){
        this.listDetailses=listDetailsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.leader_board_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListDetails listDetails = listDetailses.get(position);
        holder.rank.setText(listDetails.getRank());
        holder.level.setText(listDetails.getQuestion_no());
        holder.name.setText(listDetails.getName());
    }

    @Override
    public int getItemCount() {
        int pos=0;
        try {
            pos=listDetailses.size();

        }catch (NullPointerException e) {
            pos = 0;
        }
        return pos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemLayout)
        LinearLayout cardView;
        @BindView(R.id.rank)
        TextView rank;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.level)
        TextView level;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
