package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
<<<<<<< HEAD
import android.support.v4.app.FragmentPagerAdapter;
=======
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

<<<<<<< HEAD
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
=======
public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
        Log.d("ViewPagerAdapter",title);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
<<<<<<< HEAD

        return fragmentList.size();
    }
    public void setTabData(List<Fragment> fragmentList, List<String> fragmentTitleList) {
        this.fragmentList = fragmentList;
        this.fragmentTitleList = fragmentTitleList;
    }

=======
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
>>>>>>> e4301a092cde0713e9388c22188b231657edf1a8
}
