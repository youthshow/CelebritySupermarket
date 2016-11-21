package com.celebritysupermarket.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.celebritysupermarket.fragment.FragmentFactory;


public class HomePagerAdapter extends FragmentStatePagerAdapter {


    public HomePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }




    @Override
    public Fragment getItem(int position) {

        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }


}
