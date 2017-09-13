package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.RetrofitQuestionProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.data.QuestionDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment implements QuestionView{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Context context;
    private SharedPrefs sharedPrefs;
    private QuestionPresenter questionPresenter;
    private RecyclerAdapter recyclerAdapter;


    @BindView(R.id.question_name)
    TextView question_name;
    @BindView(R.id.question_content)
    TextView question_content;
    @BindView(R.id.question_name_layout)
    LinearLayout question_name_layout;
    @BindView(R.id.unsolved_question_layout)
    RelativeLayout unsolved_question_layout;

    @BindView(R.id.solved_heading)
    TextView solved_heading;
    @BindView(R.id.recycler_layout)
    RelativeLayout recycler_layout;
    @BindView(R.id.question_recycler)
    RecyclerView question_recycler;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;



    private OnFragmentInteractionListener mListener;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.bind(this,view);
        initialize();
        questionPresenter.requestQuestion(sharedPrefs.getAccessToken());
        return  view;
    }

    private void initialize() {
        context=getContext();
        sharedPrefs = new SharedPrefs(context);
        questionPresenter = new QuestionPresenterImpl(this,new RetrofitQuestionProvider());
        recyclerAdapter= new RecyclerAdapter(context,this);
        question_recycler.setLayoutManager(new LinearLayoutManager(context));
        question_recycler.setHasFixedSize(true);
        question_recycler.setAdapter(recyclerAdapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setData(QuestionData questionData) {
        final QuestionDetails questionDetails=questionData.getNext_question();
        question_name.setText(questionDetails.getQuestion_name());
        question_content.setText(questionDetails.getQuestion_content());
        unsolved_question_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.showShortMessage(context,questionDetails.getQuestion_no());
            }
        });
        if(questionData.getSolved_question_list().size()>0){
            solved_heading.setVisibility(View.VISIBLE);
            recycler_layout.setVisibility(View.VISIBLE);
            recyclerAdapter.setData(questionData.getSolved_question_list());
            recyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoading(boolean show) {
        if (show){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toaster.showShortMessage(context,message);
    }

    @Override
    public void enableSave(boolean save) {

    }

    @Override
    public void onEdit() {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
