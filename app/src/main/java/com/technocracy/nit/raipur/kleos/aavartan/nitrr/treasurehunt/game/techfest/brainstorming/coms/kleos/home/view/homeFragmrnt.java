package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.RetrofitHomeTabsProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabDetails;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.model.data.TabsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.presenter.HomeTabsPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.presenter.HomeTabsPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link homeFragmrnt.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link homeFragmrnt#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragmrnt extends Fragment implements HomeView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
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



    private OnFragmentInteractionListener mListener;

    public homeFragmrnt() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragmrnt.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragmrnt newInstance(String param1, String param2) {
        homeFragmrnt fragment = new homeFragmrnt();
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
        ButterKnife.bind(this,view);

        homeTabsPresenter = new HomeTabsPresenterImpl(new RetrofitHomeTabsProvider(),this);
        layoutInflater=LayoutInflater.from(getContext());
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_back_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void setTabs(TabsData tabsData) {
         List<TabDetails>tabsDetailsList=new ArrayList<>();
        tabsDetailsList = tabsData.getTabsDetailsList();
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleImageList = new ArrayList<>();
        List<String> titleNameList = new ArrayList<>();
        for (int i = 0; i <tabsDetailsList.size() ; i++) {
            for (int j = 0; j < tabsDetailsList.size(); j++) {
                if (tabsDetailsList.get(j).getPosition() == i) {
                    int value = tabsDetailsList.get(j).getValue();
                    if (value ==) {
                        ProductsListFragment fragment = ProductsListFragment.newInstance(subCategoryDetailsList.get(i).getId(), 0);
                        fragmentList.add(fragment);
                        titleImageList.add(tabsDetailsList.get(j).getImage_url());
                        titleNameList.add(tabsDetailsList.get(j).getTitle());

                    }
                    else if(value==)
                    {
                        ProductsListFragment fragment = ProductsListFragment.newInstance(subCategoryDetailsList.get(i).getId(), 0);
                        fragmentList.add(fragment);
                        titleList.add(tabsDetailsList.get(i).getImage_url());

                    }
                }

            }
        }

        viewPagerAdapter.setTabData(fragmentList, titleList);
      //  viewPager.setCurrentItem(subcategory_position);
        viewPagerAdapter.notifyDataSetChanged();



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
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
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
