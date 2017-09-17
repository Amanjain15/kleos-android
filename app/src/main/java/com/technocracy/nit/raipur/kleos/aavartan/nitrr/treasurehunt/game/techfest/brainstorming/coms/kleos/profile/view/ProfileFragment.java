package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.RetrofitProfileProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data.ProfileRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.presenter.ProfileRequestPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.presenter.ProfileRequestPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements ProfileRequestView,SwipeRefreshLayout.OnRefreshListener  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context context;
    private ProfileRequestPresenter profilePresenter;
    private SharedPrefs sharedPrefs;
    private String name,college,email;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.name_textview)
    TextView textViewName;
    @BindView(R.id.name_edittext)
    EditText edittextName;

    @BindView(R.id.phone_textview)
    TextView textViewPhone;


    @BindView(R.id.email_textview)
    TextView textViewEmail;
    @BindView(R.id.email_edittext)
    EditText edittextEmail;

    @BindView(R.id.college_textview)
    TextView textViewCollege;
    @BindView(R.id.college_edittext)
    AutoCompleteTextView edittextCollege;

    @BindView(R.id.edit)
    Button edit_button;
    @BindView(R.id.save)
    Button submit_button;

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;

    @BindView(R.id.rank_text)
    TextView rank;

    @BindView(R.id.rank)
    TextView rankt;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        context=getContext();
        ButterKnife.bind(this,view);
        initialize();

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_button.setVisibility(View.GONE);
                submit_button.setVisibility(View.VISIBLE);
                visibilityTextView(false);
                visibilityEditView(true);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        profilePresenter.requestProfile(sharedPrefs.getAccessToken());
                                    }
                                }
        );
        rankt.setVisibility(View.GONE);
        rank.setVisibility(View.GONE);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=edittextName.getText().toString();
                college=edittextCollege.getText().toString();
                email=edittextEmail.getText().toString();
                hideKeyboard();
                if (name.equals("") || name.equals(null)) {
                    edittextName.setError("Please Fill Name");
                    edittextName.setFocusable(true);
                } else if (college.equals("") || college.equals(null)) {
                    edittextCollege.setError("Please Fill College");
                    edittextCollege.setFocusable(true);
                } else {
                    profilePresenter.editProfile(sharedPrefs.getAccessToken(),name,college,email);
                }
            }
        });
        return view;
    }

    private void initialize() {
        sharedPrefs = new SharedPrefs(context);
        profilePresenter = new ProfileRequestPresenterImpl(this,new RetrofitProfileProvider());
        profilePresenter.requestProfile(sharedPrefs.getAccessToken());
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

    private void setCollegeList(String [] collegeList){
        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<String>
                (context, android.R.layout.simple_list_item_1,
                        collegeList);
        edittextCollege.setAdapter(collegeAdapter);
        edittextCollege.setThreshold(1);
    }

    @Override
    public void setData(ProfileRequestData profileRequestData) {
        submit_button.setVisibility(View.GONE);
        edit_button.setVisibility(View.VISIBLE);
        setCollegeList(profileRequestData.getCollege_list());
        visibilityTextView(true);
        visibilityEditView(false);
        textViewName.setText(profileRequestData.getName());
        textViewPhone.setText(profileRequestData.getMobile());
        textViewCollege.setText(profileRequestData.getCollege_name());
        textViewEmail.setText(profileRequestData.getEmail());

        edittextName.setText(profileRequestData.getName());
        edittextCollege.setText(profileRequestData.getCollege_name());
        edittextEmail.setText(profileRequestData.getEmail());

        if (!(profileRequestData.getRank().equals("") || profileRequestData.getRank().equals(null)||
                profileRequestData.getRank().equals("-1")
        ))
        {
            rankt.setVisibility(View.VISIBLE);
            rank.setVisibility(View.VISIBLE);
            rank.setText(profileRequestData.getRank());
        }
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            swipeRefreshLayout.setRefreshing(true);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            swipeRefreshLayout.setRefreshing(false);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toaster.showShortMessage(context,message);
    }

    @Override
    public void enableEdit(boolean edit) {
        if (edit) {
            edit_button.setEnabled(true);
        } else {
            edit_button.setEnabled(false);
        }
    }

    @Override
    public void enableSave(boolean save) {
        if (save) {
            submit_button.setEnabled(true);
        } else {
            submit_button.setEnabled(false);
        }
    }

    @Override
    public void onEdit() {
        profilePresenter.requestProfile(sharedPrefs.getAccessToken());
    }

    public void visibilityTextView(boolean show){
        if(show){
            textViewName.setVisibility(View.VISIBLE);
            textViewEmail.setVisibility(View.VISIBLE);
            textViewCollege.setVisibility(View.VISIBLE);
        }else{
            textViewName.setVisibility(View.GONE);
            textViewEmail.setVisibility(View.GONE);
            textViewCollege.setVisibility(View.GONE);
        }
    }

    public void visibilityEditView(boolean show){
        if(show){
            edittextName.setVisibility(View.VISIBLE);
            edittextEmail.setVisibility(View.VISIBLE);
            edittextCollege.setVisibility(View.VISIBLE);
        }else{
            edittextName.setVisibility(View.GONE);
            edittextEmail.setVisibility(View.GONE);
            edittextCollege.setVisibility(View.GONE);
        }
    }

    @Override
    public void onRefresh() {
        profilePresenter.requestProfile(sharedPrefs.getAccessToken());
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity()
                                                .getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
