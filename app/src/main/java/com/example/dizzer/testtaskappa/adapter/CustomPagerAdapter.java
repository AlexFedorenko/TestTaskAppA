package com.example.dizzer.testtaskappa.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.fragments.HistoryTabFragment;
import com.example.dizzer.testtaskappa.fragments.TestTabFragment;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    public CustomPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new TestTabFragment();
            case 1:
                return new HistoryTabFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return context.getString(R.string.test_tab_title);
            case 1:
                return context.getString(R.string.history_tab_title);
            default:
                return null;
        }
    }
}
