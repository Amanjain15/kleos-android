package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.Home;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.RetrofitSponserProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.model.data.SponserDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.presenter.SponserPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.presenter.SponserPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SponserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SponserFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */






public class SponserFragment extends Fragment  implements SponserView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.progressBar_sponser)
    ProgressBar progressBar;
    @BindView(R.id.recycler_sponser)
    RecyclerView recyclerView;

    private SponserPresenter sponserPresenter;
    private SharedPrefs sharedPrefs;

    private SponserAdapter sponserAdapter;
    private static FragmentActivity fragmentActivity;




    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SponserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SponserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SponserFragment newInstance(String param1, String param2) {
        SponserFragment fragment = new SponserFragment();
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
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sponser, container, false);
        ButterKnife.bind(this,view);
        fragmentActivity=getActivity();
        initialize();
        sponserPresenter.sponsers(sharedPrefs.getAccessToken());
        return view ;
    }

    private void initialize() {
        sharedPrefs = new SharedPrefs(getContext());
        sponserPresenter = new SponserPresenterImpl( new RetrofitSponserProvider(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        sponserAdapter = new SponserAdapter(getContext(), this,fragmentActivity);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(sponserAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void setSponsers(SponserData sponserData) {
        sponserAdapter.setSpons(sponserData.getSponserDetails());
        sponserAdapter.notifyDataSetChanged();

    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {

            progressBar.setVisibility(View.INVISIBLE);
        }

    }
    public void onImageClick(SponserDetails sponserDetails)
    {
//        ((Home)getContext()).onImageClick(sponserDetails);
//        Uri uri = Uri.parse(sponserDetails.getWeb_url());
//        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//        builder.setToolbarColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
//        builder.setSecondaryToolbarColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
//// set start and exit animations
//        builder.setExitAnimations(fragmentActivity, android.R.anim.slide_in_left,
//                android.R.anim.slide_out_right);
//        CustomTabsIntent customTabsIntent = builder.build();
//        customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        customTabsIntent.launchUrl(fragmentActivity, uri);

    }
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
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
