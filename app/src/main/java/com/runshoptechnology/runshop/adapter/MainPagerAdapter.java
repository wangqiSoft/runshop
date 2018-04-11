package com.runshoptechnology.runshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author Ryder
 * create at 2018/4/10 12:56
 * package name:com.runshoptechnology.runshop.adapter
 * description: 滑动的viewpager的adapter
 **/
public class MainPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
