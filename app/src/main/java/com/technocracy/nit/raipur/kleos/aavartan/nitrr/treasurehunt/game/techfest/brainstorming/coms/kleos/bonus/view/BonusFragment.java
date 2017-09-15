package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.RetrofitBonusProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.presenter.BonusPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.presenter.BonusPresenterImpl;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.model.data.QuestionDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BonusFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BonusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BonusFragment extends Fragment implements BonusView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String name;
    private String number;
    private String image;
    private String content;
    private boolean answered;

    private Context context;
    private SharedPrefs sharedPrefs;
    private BonusPresenter questionPresenter;
    private ImageLoader imageLoader;

    @BindView(R.id.imageLayout)
    RelativeLayout imageLayout;
    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.question_content)
    TextView question_content;
    @BindView(R.id.answer)
    EditText answer;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.submit)
    ImageView submit;

    @BindView(R.id.text)
    TextView textView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BonusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BonusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BonusFragment newInstance(String param1, String param2) {
        BonusFragment fragment = new BonusFragment();
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
        View view= inflater.inflate(R.layout.fragment_bonus, container, false);
        ButterKnife.bind(this,view);
        initialize();
        questionPresenter.requestQuestion(sharedPrefs.getAccessToken());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer1= answer.getText().toString();
                if (answer1.equals("")||answer1.equals(null)){
                    answer.setError("Please Fill Answer");
                    answer.requestFocus();
                }else{
                    questionPresenter.responseQuestion(sharedPrefs.getAccessToken(),number,answer1);
                }
            }
        });
        return view;

    }

    private void initialize() {
        context=getContext();
        sharedPrefs = new SharedPrefs(context);
        questionPresenter = new BonusPresenterImpl(this,new RetrofitBonusProvider());
        imageLoader= new GlideImageLoader(context);
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        QuestionDetails questionDetails= questionData.getBonus_question();
        imageLoader.loadImage(questionDetails.getQuestion_img(),imageView,imageProgressBar);
        question_content.setText(questionDetails.getQuestion_content());
        if (questionData.isAnswered()){
            answer.setVisibility(View.GONE);
            submit.setVisibility(View.GONE);
            textView.setText("You Have Answered this Question");
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
    public void onRightAnswer() {
        Toaster.showShortMessage(context, "Right Answer");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
