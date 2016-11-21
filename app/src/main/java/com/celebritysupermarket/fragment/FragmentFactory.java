package com.celebritysupermarket.fragment;

import android.support.v4.util.SparseArrayCompat;

import com.celebritysupermarket.base.BaseFragment;


/**
 * Created by tt on 2016/6/15.
 */
public class FragmentFactory {

    private static SparseArrayCompat<BaseFragment> mCaches = new SparseArrayCompat<>();

    public static BaseFragment getFragment(int position) {

        BaseFragment fragment = mCaches.get(position);

        if (fragment != null) {

            return fragment;
        }
        switch (position) {

            case 0://首页
                fragment = new HomePageFragment();
                break;
            case 1:
                fragment = new LiveFragment();
                break;
            case 2:
                fragment = new ShoppingCartFragment();
                break;
            case 3:
                fragment = new UserFragment();
                break;
            default:

                break;
        }

        // 存储
        mCaches.put(position, fragment);

        return fragment;
    }

}
