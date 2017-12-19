package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.about_us.view.AboutUsFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.bonus.view.BonusFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.MyApplication;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.hints.view.HintsFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.RetrofitHomeTabsProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.presenter.HomeTabsPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.presenter.HomeTabsPresenterImpl;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.leaderboard.view.LeaderBoardFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.view.ProfileFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view.QuestionFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sponser.view.SponserFragment;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.storyline.view.StorylineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private SharedPrefs sharedPrefs;
    private TabsData tabsData;

    private ViewPagerAdapter viewPagerAdapter;
    private HomeTabsPresenter homeTabsPresenter;
    private LayoutInflater layoutInflater;
    private static Context context;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view=inflater.inflate(R.layout.fragment_home_fragmrnt, container, false);
        context=getContext();
        ButterKnife.bind(this,view);
        initialize();
        String fcm;
        if((sharedPrefs.getKeyFcm().equals("fcm") || sharedPrefs.getKeyFcm().equals("") ||
                sharedPrefs.getKeyFcm().equals(null)) ){
            fcm=MyApplication.getFcm_token();
            Log.d("FCM",fcm+"created");
            sharedPrefs.setFcm(fcm);
        }else{
            fcm=sharedPrefs.getKeyFcm();
            Log.d("FCM",fcm+"taken");
        }

        homeTabsPresenter.getTabs(sharedPrefs.getAccessToken(),fcm);
        return view;
    }

    private void initialize() {
        sharedPrefs = new SharedPrefs(context);
        homeTabsPresenter = new HomeTabsPresenterImpl(new RetrofitHomeTabsProvider(),this);
//        homeTabsPresenter = new HomeTabsPresenterImpl(new MockHomeProvider(),this);
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void setTabs(final TabsData tabsData) {
        ProfileFragment profileFragment = new ProfileFragment();
        StorylineFragment storylineFragment= new StorylineFragment();
        SponserFragment sponserFragment= new SponserFragment();
        AboutUsFragment aboutUsFragment= new AboutUsFragment();
        HintsFragment hintsFragment = new HintsFragment();
        LeaderBoardFragment leaderBoardFragment = new LeaderBoardFragment();
        BonusFragment bonusFragment= new BonusFragment();
        QuestionFragment questionFragment=new QuestionFragment();
        TabDetails tabDetails;
        toolbar.setTitle("Kleos");
        try {
            for (int i = 0; i < tabsData.getTab_list().size(); i++) {
                tabDetails = tabsData.getTab_list().get(i);
                Log.d("HomeTab",""+tabDetails.getId());
                switch (tabDetails.getId()) {

                    case Keys.FRAGMENT_TYPE_PROFILE:
                        viewPagerAdapter.addFragment(profileFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_STORYLINE:
                        viewPagerAdapter.addFragment(storylineFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_SPONSOR:
                        viewPagerAdapter.addFragment(sponserFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_ABOUT_US:
                        viewPagerAdapter.addFragment(aboutUsFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_HINTS:
                        viewPagerAdapter.addFragment(hintsFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_BONUS:
                        viewPagerAdapter.addFragment(bonusFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_QUESTIONS:
                        viewPagerAdapter.addFragment(questionFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                    case Keys.FRAGMENT_TYPE_LEADER_BOARD:
                        viewPagerAdapter.addFragment(leaderBoardFragment, tabDetails.getTitle());
                        viewPagerAdapter.notifyDataSetChanged();
                        break;
                }
                viewPagerAdapter.notifyDataSetChanged();
            }
            for (int i = 0; i < tabsData.getTab_list().size(); i++) {
                tabDetails = tabsData.getTab_list().get(i);
                Log.d("HomeTab",""+tabDetails.getId());
                switch (tabDetails.getId()) {

                    case Keys.FRAGMENT_TYPE_PROFILE:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_PROFILE_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_STORYLINE:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_STORYLINE_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_SPONSOR:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_SPONSOR_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_ABOUT_US:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_ABOUT_US_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_HINTS:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_GAME_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_BONUS:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_BONUS_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_QUESTIONS:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_QUESTION_ICON);
                        }
                        break;
                    case Keys.FRAGMENT_TYPE_LEADER_BOARD:
                        if (tabLayout.getTabAt(i) != null) {
                            tabLayout.getTabAt(i).setIcon(Keys.TAB_LEADER_BOARD_ICON);
                        }
                        break;
                }
            }

        }catch (NullPointerException e){
            Toaster.showShortMessage(context,"Null Pointer in ViewPager Set Data");
        }
        viewPager.setOffscreenPageLimit(tabsData.getTab_list().size()-1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TabDetails tabDetails;
                tabDetails = tabsData.getTab_list().get(position);
                toolbar.setTitle(tabDetails.getTitle());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {

            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toaster.showShortMessage(context,message);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
