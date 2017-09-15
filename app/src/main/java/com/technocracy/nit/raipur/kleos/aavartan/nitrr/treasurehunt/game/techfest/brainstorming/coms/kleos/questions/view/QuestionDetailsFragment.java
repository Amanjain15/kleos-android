package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.RetrofitQuestionProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionDetailsFragment extends Fragment implements  QuestionResponseView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NAME = "name";
    private static final String ARG_NUMBER= "no";
    private static final String ARG_IMAGE= "image";
    private static final String ARG_CONTENT= "content";
    private static final String ARG_ANSWERED= "answered";

    // TODO: Rename and change types of parameters
    private String name;
    private String number;
    private String image;
    private String content;
    private boolean answered;

    private Context context;
    private SharedPrefs sharedPrefs;
    private QuestionPresenter questionPresenter;
    private ImageLoader imageLoader;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
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

    private OnFragmentInteractionListener mListener;

    public QuestionDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionDetailsFragment newInstance(String param1, String param2,String param3, String param4,String param5) {
        QuestionDetailsFragment fragment = new QuestionDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        args.putString(ARG_NUMBER, param2);
        args.putString(ARG_IMAGE, param3);
        args.putString(ARG_CONTENT, param4);
        args.putString(ARG_ANSWERED, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name= getArguments().getString(ARG_NAME);
            number = getArguments().getString(ARG_NUMBER);
            image = getArguments().getString(ARG_IMAGE);
            content = getArguments().getString(ARG_CONTENT);
            answered=getArguments().getBoolean(ARG_ANSWERED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_question_details, container, false);
        ButterKnife.bind(this,view);
        toolbar.setTitle(name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        initialize();
        question_content.setText(content);
        if(answered){
            submit.setVisibility(View.GONE);
            answer.setVisibility(View.GONE);
        }
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
        imageLoader= new GlideImageLoader(context);
        imageLoader.loadImage(image,imageView,imageProgressBar);
        questionPresenter=new QuestionPresenterImpl(new RetrofitQuestionProvider(),this);
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
    public void onRightAnswer() {
        Toaster.showShortMessage(context,"Correct Answer");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().onBackPressed();
            }
        },500);
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
