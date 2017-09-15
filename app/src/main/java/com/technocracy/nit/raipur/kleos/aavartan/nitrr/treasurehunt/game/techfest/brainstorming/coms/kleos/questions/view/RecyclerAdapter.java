package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aman on 12/9/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<QuestionDetails> questionDetailsList;
    private QuestionFragment questionFragment;
    private ImageLoader imageLoader;

    public RecyclerAdapter(Context context, QuestionFragment questionFragment) {
        this.context = context;
        this.questionFragment = questionFragment;
        this.layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }

    public void setData(List<QuestionDetails> questionDetailses){
        this.questionDetailsList=questionDetailses;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.solved_question_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        final QuestionDetails questionDetails = questionDetailsList.get(position);
        holder.question_name.setText(questionDetails.getQuestion_name());
        holder.question_content.setText(questionDetails.getQuestion_content());
        holder.question_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("QuestionRecyclerAdapter",questionDetails.getQuestion_no());
                Toaster.showShortMessage(context,questionDetails.getQuestion_no());
            }
        });
    }

    @Override
    public int getItemCount() {
        int pos;
        if(questionDetailsList.size()>0){
            pos=questionDetailsList.size();
        }else{
            pos=0;
        }

        return pos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.question_name)
        TextView question_name;
        @BindView(R.id.question_content)
        TextView question_content;
        @BindView(R.id.question_name_layout)
        LinearLayout question_name_layout;
        @BindView(R.id.question_layout)
        RelativeLayout question_layout;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
